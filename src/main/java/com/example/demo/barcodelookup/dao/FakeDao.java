package com.example.demo.barcodelookup.dao;
import com.example.demo.barcodelookup.model.Product;
import org.springframework.stereotype.Repository;

@Repository("FakeBarcodeDao")
public class FakeDao implements ItemLookupDao {

    @Override
    public Product returnProductSaveIfNotFound(String barcode) {
        return new Product("temp name","123656545");
    }

    @Override
    public Product callThirdPartyApiIfDoesntExist(String barcode) {
        return new Product("temp name","123656545");

    }

    @Override
    public Product callBarCodeApi(String barcode) {
        return new Product("temp name","123656545");

    }

    @Override
    public void addNewBarcode(String barcode) {

    }
}
