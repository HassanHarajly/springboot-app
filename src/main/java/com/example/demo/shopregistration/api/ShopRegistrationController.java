package com.example.demo.shopregistration.api;

import com.example.demo.shopregistration.dao.repositories.ShopRepository;
import com.example.demo.shopregistration.models.Shop;
import com.example.demo.shopregistration.services.GeoCacheApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/")
@RestController
public class ShopRegistrationController {

    GeoCacheApiService geoCacheApiService = new GeoCacheApiService();
    @Autowired
    ShopRepository shopRepository;
    @PostMapping(path = "addNewShop")
    public void addNewShop(@RequestBody @Valid @NonNull Shop shop) {
        shopRepository.save(shop);
    }

    @GetMapping(path = "getAllShops")
    public List<Shop> getAllShops() {
        final List<Shop> shops = new ArrayList<>();
        shopRepository.findAll().forEach(Shop -> shops.add(Shop));
        return shops;
    }

    @GetMapping(path = "getShopByName")
    public List<Shop> getShopByName(@RequestParam String name) {
        return shopRepository.findByName(name);
    }

    @GetMapping(path = "getProximalShop")
    public List<Shop> getProximalShops(@RequestParam double longitude,@RequestParam double latitude) {
        return shopRepository.getProximalShops(latitude,longitude);
    }

}
