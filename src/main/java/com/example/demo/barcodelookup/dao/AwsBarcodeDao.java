package com.example.demo.barcodelookup.dao;

import com.example.demo.barcodelookup.model.Product;
import com.example.demo.tutorial.dao.PersonDataAccessService;
import com.example.demo.tutorial.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("MySql")

public class AwsBarcodeDao implements ItemLookupDao {

    private JdbcTemplate jdbcTemplate;


    public AwsBarcodeDao(@Autowired JdbcTemplate jdbc)
    {
        jdbcTemplate=jdbc;

    }

    private List<Product> products = new ArrayList<>();

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
            return new Product("no product exists","000");
        }

    }

    public Product returnProductDontSaveIfNotFound(String barcode)
    {

        final String selectProductSql = "SELECT barcodeOrUpc, productName FROM productData WHERE barCodeOrUpc ="+barcode+";";
        products =   jdbcTemplate.query(selectProductSql, new ProductRowMapper());

        if (products.size()>0)
        {
            return products.get(0);
        }
        else{
            return new Product("no product exists not saving","000");
        }
    }

    public void addNewBarcode(String barcode)
    {
        String insertProductQuery  = "INSERT INTO BarcodeNotFound (barcode) VALUES(" +barcode+ ")";
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
