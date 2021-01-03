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
    @Query( value = "DECLARE @TestVariable AS VARCHAR(400) SET @TestVariable = 'computer water' SET @TestVariable = CONCAT('\"',@TestVariable,'\"') SELECT top 20 * FROM products  WHERE CONTAINS(product_name,@TestVariable)"

    , nativeQuery = true)
    List<InStoreProduct> findByName(@Param("product_name") String product_name);
}
