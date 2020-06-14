package com.example.demo.barcodelookup.dao;

import com.example.demo.barcodelookup.model.Product;

public interface ItemLookupDao {

    public Product queryByBarcode(String  barcode);
}
