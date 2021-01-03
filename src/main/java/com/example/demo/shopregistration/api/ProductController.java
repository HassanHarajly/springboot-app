package com.example.demo.shopregistration.api;

import com.example.demo.shopregistration.dao.repositories.ProductRepository;
import com.example.demo.shopregistration.models.InStoreProduct;
import com.example.demo.shopregistration.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("addNewProduct")
    public void insertNewProduct(@RequestBody @Valid @NonNull InStoreProduct inStoreProduct) {
        productRepository.save(inStoreProduct);
    }

    @GetMapping("getProductByName")
    List<InStoreProduct> getAllSimilarProducts(@RequestParam String name) {
        List<InStoreProduct> products = new ArrayList<>();
            productRepository.findByName(name).forEach(product -> {
                products.add(product);
            });
        return products;
    }

    @GetMapping(path = "getProximalProduct")
    public List<InStoreProduct> getProximalShops(@RequestParam double longitude, @RequestParam double latitude) {
        return productRepository.getProximalProduct(latitude,longitude);
    }
}
