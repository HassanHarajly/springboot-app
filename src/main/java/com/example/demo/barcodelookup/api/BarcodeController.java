package com.example.demo.barcodelookup.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/itemLookup")
@RestController
public class BarcodeController {


    @GetMapping(path = "{id}")
    public String returnFunction(@PathVariable("id")int test)
    {
        return Integer.toString(test);
    }
}
