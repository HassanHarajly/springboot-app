package com.example.demo.shopregistration.dao.repositories;

import com.example.demo.barcodelookup.model.Product;
import com.example.demo.shopregistration.models.InStoreProduct;
import com.example.demo.shopregistration.models.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<InStoreProduct,Integer> {
//    @Query(
//            value = "SELECT * FROM product_information product WHERE product.product_name = ?1",
//            nativeQuery = true)
//    List<Shop> findByZip(String zip);
}
