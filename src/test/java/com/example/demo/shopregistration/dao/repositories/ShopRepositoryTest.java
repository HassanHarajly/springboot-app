package com.example.demo.shopregistration.dao.repositories;

import com.example.demo.shopregistration.models.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ShopRepositoryTest {

    @Autowired
    ShopRepository shopRepository;
    @Test
    void testFindByZip() {
    }

    @Test
    void testFindByName() {
    }

    @Test
    void testInsertshop() {
    }

    @Test
    void testGetProximalShopsWithNonZeroDistance() {

        shopRepository.insertshop("target1","1 main st","48127","mi",55.345916365908124,-83.16365162629968);
        AtomicReference<Shop> selectedShop = new AtomicReference<>(new Shop());
       shopRepository.getProximalShops(42.345916365908124,-83.16365162629968).forEach(


               (shop) -> {
                   // yes, we can put logic here
                   if (shop.getShop_name() == "target1"){
                       selectedShop.set(shop);
                   }
               }


       );
        assertEquals(selectedShop.get().getShop_name() ,"target1");
        assertEquals(selectedShop.get().getDistance() ,898.2686061239193);
    }

    @Test
    void testGetProximalShopsWithZeroDistance() {
        AtomicReference<Shop> selectedShop = new AtomicReference<>(new Shop());

        shopRepository.insertshop("target2","1 main st","48127","mi",42.345916365908124,-83.16365162629968);
        shopRepository.getProximalShops(42.345916365908124,-83.16365162629968).forEach(


                (shop) -> {
                    // yes, we can put logic here
                    if (shop.getShop_name() == "target2"){
                        selectedShop.set(shop);
                    }
                }


        );
        assertEquals(selectedShop.get().getShop_name() ,"target2");
        assertEquals(selectedShop.get().getDistance() ,0);
    }
}
