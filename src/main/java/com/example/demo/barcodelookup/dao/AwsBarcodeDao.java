package com.example.demo.barcodelookup.dao;
import com.example.demo.barcodelookup.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("MySql")

public class AwsBarcodeDao implements ItemLookupDao {

    @Value("${loggingUniqueIdentifier}")
    private String logID;
    Logger logger = LoggerFactory.getLogger(AwsBarcodeDao.class);
    private JdbcTemplate jdbcTemplate;
    private List<Product> products = new ArrayList<>();
    @Autowired
    private ThirdPartyApi TPA;


    public AwsBarcodeDao(@Autowired JdbcTemplate jdbc)
    {
        jdbcTemplate=jdbc;
    }

    public Product returnProductSaveIfNotFound(String barcode)
    {
        final String selectProductSql = "SELECT barcodeOrUpc, productName FROM productData WHERE barCodeOrUpc ="+barcode+";";
        products =   jdbcTemplate.query(selectProductSql, new ProductRowMapper());
        if (products.size()>0)
        {
        return products.get(0);
        }
        else{
            addNewBarcode(barcode);
            return new Product("n/a","n/a");
        }
    }

// we still add the product to the BarcodeNotFound database since the acceptable use policy of the 3rdparty api states users cant use it to mine data or copy it so well try to gather it later.
    public Product callThirdPartyApiIfDoesntExist(String barcode)
    {
        try {
        final String selectProductSql = "SELECT barcodeOrUpc, productName FROM productData WHERE barCodeOrUpc ="+barcode+";";
        products =   jdbcTemplate.query(selectProductSql, new ProductRowMapper());
        if (products.size()>0)
        {
            return products.get(0);
        }
        else{
            logger.info(logID + "It appears the barcode sent has not been found in our database the next step after this log is to query the 3rd party api");
            addNewBarcode(barcode);
            return callBarCodeApi(barcode);
        }
        }
        catch(Exception e)
        {
            logger.error(logID + "there was a problem with callThirdPartyApiIfDoesntExist function in awsBarcodeDao.java class");
        }
        return null;

    }

    public Product callBarCodeApi(String barcode)
    {
        try {
            return TPA.queryPopularApiForPossibleMatch(barcode);
        }catch (Exception ex)
        {
            System.out.println("ThirdPartyApi class has thrown an exception see details below for stack trace");
            ex.printStackTrace();
        }
        return null;
    }
    //this database is for data gathering at a later date, if the user asks for a barcode that we dont have stored in productData we add it.
    public void addNewBarcode(String barcode)
    {
        String insertProductQuery  = "INSERT IGNORE INTO BarcodeNotFound (barcode) VALUES(" +barcode+ ")";
        jdbcTemplate.update(insertProductQuery);
    }

    private  static  class ProductRowMapper implements  RowMapper<Product>{

        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product product = new Product(resultSet.getString("productName"),resultSet.getString("barcodeOrUpc"));
            return product;
        }
    }

}
