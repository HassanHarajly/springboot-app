package com.example.demo.barcodelookup.service;
import com.example.demo.barcodelookup.dao.AwsBarcodeDao;
import com.example.demo.barcodelookup.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemLookupService {

    AwsBarcodeDao awsBarcodeDao;

    public ItemLookupService(@Qualifier("MySql") AwsBarcodeDao awsBarcodeDao) {
        this.awsBarcodeDao = awsBarcodeDao;
    }

    public Optional<Product> findBarCodeSaveIfNotFound(String barcode)
    {
        Optional<Product> optionalProduct = Optional.ofNullable(awsBarcodeDao.returnProductSaveIfNotFound(barcode));
        return optionalProduct;
    }
    
    public  Optional<Product> ifDoesntExistUseVendorData(String barcode)
    {

        Optional<Product> optionalProduct = Optional.ofNullable(awsBarcodeDao.callThirdPartyApiIfDoesntExist(barcode));
        return optionalProduct;

    }

}
