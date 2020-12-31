package com.example.demo.shopregistration.api;

import com.example.demo.shopregistration.dao.repositories.ProductRepository;
import com.example.demo.shopregistration.models.InStoreProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/")
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("getAllProducts")
    List<InStoreProduct> getAllProducts() {
        List<InStoreProduct> products = new ArrayList<>();
         productRepository.findAll().forEach(shop -> {
            products.add(shop);
        });
         return products;
    }

}
