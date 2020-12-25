package com.example.demo.shopregistration.api;

import com.example.demo.shopregistration.dao.repositories.ShopRepository;
import com.example.demo.shopregistration.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/")
@RestController
public class ShopRegistrationController {

    @Autowired
    ShopRepository shopRepository;
    @PostMapping(path = "addNewShop")
    public List<Shop> addNewBarCode(@RequestBody @Valid @NonNull Shop shop) {

      //  shopRepository.save(new Shop(1,"2","3s","ss","mi"));
        final List<Shop> shops = new ArrayList<>();
        shopRepository.findAll().forEach(Shop -> shops.add(Shop));
        return shops;

    }





}
