package com.example.demo.barcodelookup.dao;
import com.example.demo.barcodelookup.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AwsBarcodeDaoTest {

    @InjectMocks
    AwsBarcodeDao awsBarcodeDao;
    @Mock
    public JdbcTemplate jdbcTemplate;
    public List<Product> products = new ArrayList<>();
    Product product = new Product("testing","000");

    @Test
    void returnProductSaveIfNotFoundValidReturn() {
        products.add(new Product("item","123456789111"));
        when(jdbcTemplate.query(any(String.class), any(RowMapper.class))).thenReturn(products);
        product= awsBarcodeDao.returnProductSaveIfNotFound("item");
        assertEquals("item", product.getProductName());
        assertEquals("123456789111", product.getProductBarcode());

    }

    @Test
    void returnProductSaveIfNotFoundNullReturn() {
        products.add(new Product("item","123456789111"));
        when(jdbcTemplate.query(any(String.class), any(RowMapper.class))).thenReturn(new ArrayList<Product>());
        product= awsBarcodeDao.returnProductSaveIfNotFound("item");
        assertEquals("n/a", product.getProductName());
        assertEquals("n/a", product.getProductBarcode());
    }

    @Test
    void callThirdPartyApiIfDoesntExist() {
    }

    @Test
    void callBarCodeApi() {
    }

    @Test
    void addNewBarcode() {
    }
}
