package com.example.demo.barcodelookup.dao;

import com.example.demo.barcodelookup.model.Product;

public interface ItemLookupDao {

    Product returnProductSaveIfNotFound(String  barcode);
    Product callThirdPartyApiIfDoesntExist(String barcode);
    Product callBarCodeApi(String barcode);
    void addNewBarcode(String barcode);
}
