package com.example.demo.barcodelookup.service;
import com.example.demo.barcodelookup.dao.AwsBarcodeDao;
import com.example.demo.barcodelookup.dao.ItemLookupDao;
import com.example.demo.barcodelookup.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemLookupService {

    ItemLookupDao itemLookupDao;

    public ItemLookupService(  @Qualifier("FakeBarcodeDao") ItemLookupDao itemLookupDao) {
        this.itemLookupDao = itemLookupDao;
    }

    public Optional<Product> findBarCodeSaveIfNotFound(String barcode)
    {
        Optional<Product> optionalProduct = Optional.ofNullable(itemLookupDao.returnProductSaveIfNotFound(barcode));
        return optionalProduct;
    }
    
    public  Optional<Product> ifDoesntExistUseVendorData(String barcode)
    {

        Optional<Product> optionalProduct = Optional.ofNullable(itemLookupDao.callThirdPartyApiIfDoesntExist(barcode));
        return optionalProduct;
    }

}
