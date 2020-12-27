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
    public List<Shop> addNewShop(@RequestBody @Valid @NonNull Shop shop) {
       shopRepository.insertshop(shop.getShop_name(),shop.getShop_street_address(),shop.getShop_zip(),shop.getShop_state());
        return shopRepository.findByName(shop.getShop_name());

    }

    @GetMapping(path = "getAllShops")
    public List<Shop> getAllShops() {
        final List<Shop> shops = new ArrayList<>();
        shopRepository.findAll().forEach(Shop -> shops.add(Shop));
        return shops;
    }



}
