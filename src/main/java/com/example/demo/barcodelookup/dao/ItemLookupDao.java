package com.example.demo.barcodelookup.dao;

import com.example.demo.barcodelookup.model.Product;

public interface ItemLookupDao {

    public Product returnProductSaveIfNotFound(String  barcode);
}
