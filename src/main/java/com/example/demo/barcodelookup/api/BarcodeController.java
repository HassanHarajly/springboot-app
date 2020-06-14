package com.example.demo.barcodelookup.api;

import com.example.demo.barcodelookup.service.ItemLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/itemLookup")
@RestController
public class BarcodeController {

    private final ItemLookupService itemLookupService;

    @Autowired
    public BarcodeController(ItemLookupService itemLookupService) {
        this.itemLookupService = itemLookupService;
    }

    @GetMapping(path = "{id}")
    public String returnFunction(@PathVariable("id")int test)
    {
        return itemLookupService.findBarCode();
    }

}
