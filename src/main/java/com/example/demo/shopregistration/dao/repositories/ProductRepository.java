package com.example.demo.shopregistration.dao.repositories;
import com.example.demo.shopregistration.models.InStoreProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<InStoreProduct,Integer> {
    @Query(
            value =
                    "SELECT top 20 *,   distance = GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(latitude, longitude, 4326)) / 1609.344 from products ORDER BY distance ASC",
            nativeQuery = true)
    List<InStoreProduct> getProximalProduct(@Param("user_latitude") Double userlatitude,@Param("user_longitude") Double userlongitude);
// todo this logic works on keywords such as "computer water" should implement some logic that if this query returns nothing to try and split it by spaces and make additional queries to get as close as possible result.
    @Query( value = "DECLARE @TestVariable AS VARCHAR(400) SET @TestVariable = :product_name SET @TestVariable = CONCAT('\"',@TestVariable,'\"') SELECT * FROM products AS FT_TBL INNER JOIN FREETEXTTABLE(products, product_name, @TestVariable) AS KEY_TBL ON FT_TBL.id = KEY_TBL.[KEY] WHERE KEY_TBL.RANK >= 10 ORDER BY KEY_TBL.RANK DESC "

    , nativeQuery = true)
    List<InStoreProduct> findByName(@Param("product_name") String product_name);

    @Query(value= " DECLARE @ProductName AS VARCHAR(400) SET @ProductName = :product_name SET @ProductName = CONCAT('\\\"',@ProductName,'\\\"') SELECT * FROM( SELECT *, distance = (GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(latitude, longitude, 4326)) / 1609.344) FROM products WHERE (GEOGRAPHY\\:\\:Point(:user_latitude, :user_longitude, 4326).STDistance(GEOGRAPHY\\:\\:Point(latitude, longitude, 4326)) / 1609.344) < 70000) AS FT_TBL INNER JOIN FREETEXTTABLE(products, product_name, @ProductName) AS KEY_TBL ON FT_TBL.id = KEY_TBL.[key] WHERE KEY_TBL.RANK >= 10 ORDER BY KEY_TBL.RANK ASC ,distance ASC"
            ,nativeQuery = true)
    List<InStoreProduct> findByNameAndProximity(@Param("product_name") String product_name,@Param("user_latitude") Double userlatitude,@Param("user_longitude") Double userlongitude);

}
