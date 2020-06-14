package com.example.demo.barcodelookup.dao;

import com.example.demo.barcodelookup.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("MySql")

public class AwsBarcodeDao implements ItemLookupDao {

    private ArrayList<Product> products = new ArrayList<>();
    public String queryForBarCode()
    {

        products.add(new Product());
        return "awsmysql";
    }

}
