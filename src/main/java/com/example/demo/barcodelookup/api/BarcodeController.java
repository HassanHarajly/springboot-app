package com.example.demo.barcodelookup.api;

import com.example.demo.barcodelookup.model.Product;
import com.example.demo.barcodelookup.service.ItemLookupService;
import com.example.demo.tutorial.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/itemLookup")
@RestController
public class BarcodeController {

    private final ItemLookupService itemLookupService;

    @Autowired
    public BarcodeController(ItemLookupService itemLookupService) {
        this.itemLookupService = itemLookupService;
    }


    @PostMapping(path = "saveifnotfound/{id}")
    public Product addNewBarCode( @Valid @NonNull @PathVariable("id")String id)
    {
        System.out.println(id);
        return itemLookupService.findBarCodeSaveIfNotFound(id);
    }

    @GetMapping(path = "dontsaveifnotfound/{id}")
    public Product returnWithoutSaving( @Valid @NonNull @PathVariable("id")String id)
    {
        System.out.println(id);
        return itemLookupService.findBarCodeDontSaveIfNotFound(id);
    }
}
