package com.example.demo.barcodelookup.api;
import com.example.demo.barcodelookup.model.Product;
import com.example.demo.barcodelookup.service.ItemLookupService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
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
    void returnValidBarcode() {
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
