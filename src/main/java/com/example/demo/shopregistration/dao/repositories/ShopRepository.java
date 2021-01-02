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
            value = "SELECT *,(-1) as distance FROM shops WHERE shop_name = ?1",
            nativeQuery = true)
    List<Shop> findByName(String shop_name);
    @Transactional
    @Modifying
    @Query(
            value =
                    "insert into shops (shop_name, shop_street_address, shop_zip, shop_state,SHOP_LATITUDE,SHOP_LONGITUDE) values (:shop_name, :shop_street_address, :shop_zip, :shop_state,:SHOP_LATITUDE,:SHOP_LONGITUDE)",
            nativeQuery = true)
    void insertshop(@Param("shop_name") String shop_name, @Param("shop_street_address") String shop_street_address,
                    @Param("shop_zip") String shop_zip, @Param("shop_state") String shop_state, @Param("SHOP_LATITUDE") double SHOP_LATITUDE, @Param("SHOP_LONGITUDE") double SHOP_LONGITUDE);

    @Query(
            value =
    "SELECT top 20 *,   distance = GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(SHOP_LATITUDE, SHOP_LONGITUDE, 4326)) / 1609.344 from shops ORDER BY distance ASC",
    nativeQuery = true)
    List<Shop> getProximalShops(@Param("user_latitude") Double userlatitude,@Param("user_longitude") Double userlongitude);


    @Query(value = "SELECT *,(-1) as distance FROM shops",
    nativeQuery = true
    )
    List<Shop> findAll();

}
