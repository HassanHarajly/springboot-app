package com.example.demo.barcodelookup.service;

import com.example.demo.barcodelookup.dao.AwsBarcodeDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ItemLookupService {

    AwsBarcodeDao awsBarcodeDao;

    public ItemLookupService(@Qualifier("MySql") AwsBarcodeDao awsBarcodeDao) {
        this.awsBarcodeDao = awsBarcodeDao;
    }

    public String findBarCode()
    {
        return awsBarcodeDao.queryForBarCode();
    }
}
