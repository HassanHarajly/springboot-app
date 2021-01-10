package com.example.demo.shopregistration.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "products")
@NoArgsConstructor
public class InStoreProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    int shop_id;
    String product_name;
    int product_quantity;
    String product_barcode;
    double product_price;
    double latitude;
    double longitude;
    double distance;
}
