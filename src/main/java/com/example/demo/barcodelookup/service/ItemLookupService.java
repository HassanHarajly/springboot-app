package com.example.demo.barcodelookup.service;

import com.example.demo.barcodelookup.dao.AwsBarcodeDao;
import com.example.demo.barcodelookup.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ItemLookupService {

    AwsBarcodeDao awsBarcodeDao;

    public ItemLookupService(@Qualifier("MySql") AwsBarcodeDao awsBarcodeDao) {
        this.awsBarcodeDao = awsBarcodeDao;
    }

    public Product findBarCodeSaveIfNotFound(String barcode)
    {
        return awsBarcodeDao.returnProductSaveIfNotFound(barcode);
    }
    public Product findBarCodeDontSaveIfNotFound(String barcode)
    {
        return awsBarcodeDao.returnProductDontSaveIfNotFound(barcode);
    }
}
