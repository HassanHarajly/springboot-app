package com.example.demo.barcodelookup.dao;

import org.springframework.stereotype.Repository;

@Repository("MySql")

public class AwsBarcodeDao implements ItemLookupDao {

    public String queryForBarCode()
    {
        return "awsmysql";
    }

}
