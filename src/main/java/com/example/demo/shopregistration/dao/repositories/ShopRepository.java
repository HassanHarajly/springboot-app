package com.example.demo.shopregistration.dao.repositories;

import com.example.demo.shopregistration.models.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {

    @Query(
            value = "SELECT * FROM shop_information shops WHERE shops.shop_zip = ?1",
            nativeQuery = true)
    List<Shop> findByZip(String zip);

}
