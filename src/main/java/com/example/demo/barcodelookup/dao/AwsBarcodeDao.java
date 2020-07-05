package com.example.demo.barcodelookup.dao;
import com.example.demo.barcodelookup.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("MySql")

public class AwsBarcodeDao implements ItemLookupDao {

    private JdbcTemplate jdbcTemplate;
    private List<Product> products = new ArrayList<>();
    private ThirdPartyApi TPA = new ThirdPartyApi();

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
        final String selectProductSql = "SELECT barcodeOrUpc, productName FROM productData WHERE barCodeOrUpc ="+barcode+";";
        products =   jdbcTemplate.query(selectProductSql, new ProductRowMapper());
        if (products.size()>0)
        {
            return products.get(0);
        }
        else{
            addNewBarcode(barcode);
            return callBarCodeApi(barcode);
        }
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
