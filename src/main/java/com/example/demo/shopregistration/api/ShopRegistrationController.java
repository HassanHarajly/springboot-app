package com.example.demo.shopregistration.api;

import com.example.demo.shopregistration.models.Shop;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api/v1/")
@RestController
public class ShopRegistrationController {



    @PostMapping(path = "addNewShop")
    public Shop addNewBarCode(@RequestBody @Valid @NonNull Shop shop) {

         return shop;
    }

}
