package com.example.demo.shopregistration.dao.repositories;

import com.example.demo.shopregistration.models.Shop;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {

    @Query(
            value = "SELECT * FROM shop_information shops WHERE shops.shop_zip = ?1",
            nativeQuery = true)
    List<Shop> findByZip(String zip);
    @Query(
            value = "SELECT * FROM shop_information shops WHERE shops.shop_name = ?1",
            nativeQuery = true)
    List<Shop> findByName(String shop_name);
    @Transactional
    @Modifying
    @Query(
            value =
                    "insert into shop_information (shop_name, shop_street_address, shop_zip, shop_state) values (:shop_name, :shop_street_address, :shop_zip, :shop_state)",
            nativeQuery = true)
    void insertshop(@Param("shop_name") String shop_name, @Param("shop_street_address") String shop_street_address,
                    @Param("shop_zip") String shop_zip, @Param("shop_state") String shop_state);

    @Query(
            value =
    "SELECT id, (3959 *acos(cos(radians(:user_latitude)) *cos(radians(shop_information.shop_latitude)) *cos(radians(shop_information.shop_latitude) -radians(:user_longitude)) +sin(radians(:user_latitude)) *sin(radians(shop_information.shop_latitude )))) AS distance FROM shop_information HAVING distance < 28 ORDER BY distance LIMIT 0, 20",
    nativeQuery = true)
    List<Shop> getProximalShops(@Param("user_latitude") Double userlatitude,@Param("user_longitude") Double userlongitude);
}
