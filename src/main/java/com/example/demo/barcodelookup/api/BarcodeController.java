package com.example.demo.barcodelookup.api;
import com.example.demo.barcodelookup.model.Product;
import com.example.demo.barcodelookup.service.ItemLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api/v1/itemLookup")
@RestController
public class BarcodeController {

    private final ItemLookupService itemLookupService;
    @Autowired
    public BarcodeController(ItemLookupService itemLookupService) {
        this.itemLookupService = itemLookupService;
    }
    Logger logger = LoggerFactory.getLogger(BarcodeController.class);


    @PostMapping(path = "ifDoesntExistStoreForDataGathering/{id}")
    public Optional<Product> addNewBarCode(@Valid @NonNull @PathVariable("id")String id)
    {
        return itemLookupService.findBarCodeSaveIfNotFound(id);
    }

    @GetMapping(path = "ifDoesntExistUseVendorData/{id}")
    public Object ifDoesntExistUseVendorData(@Valid @NonNull @PathVariable("id")String id) {
        return itemLookupService.ifDoesntExistUseVendorData(id).orElseThrow(() -> new RuntimeException("Our database and 3rd party api has not found the barcode please check if api key is still valid"));
    }



}
