package com.example.demo.barcodelookup.api;

import com.example.demo.barcodelookup.dao.AwsBarcodeDao;
import com.example.demo.barcodelookup.model.Product;
import com.example.demo.barcodelookup.service.ItemLookupService;
import com.example.demo.tutorial.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class BarcodeControllerTest {


    @Mock
    private ItemLookupService itemLookupService;

    @InjectMocks
    private BarcodeController barcodeController;

    Product product = new Product("testing","123");
    @Test
    void addNewBarCode() {

        when(itemLookupService.findBarCodeSaveIfNotFound("123"))
                .thenReturn(product);



        Product testProduct = barcodeController.addNewBarCode("123");
        assertEquals(testProduct.getProductBarcode(),"123");
    }

    @Test
    void ifDoesntExistUseVendorData() {

        when(itemLookupService.ifDoesntExistUseVendorData("123"))
                .thenReturn(product);



        Product testProduct = barcodeController.ifDoesntExistUseVendorData("123");
        assertEquals(testProduct.getProductBarcode(),"123");
    }

    @Test
    void ifDoesntExistUseVendorDataNullReturn() {

        when(itemLookupService.ifDoesntExistUseVendorData("123"))
                .thenReturn(product);



        Product testProduct = barcodeController.ifDoesntExistUseVendorData("fth");
        assertEquals(testProduct,null);
    }
}
