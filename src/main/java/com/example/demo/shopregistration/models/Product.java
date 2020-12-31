package com.example.demo.shopregistration.models;

import javax.persistence.*;
import java.util.UUID;

@Entity

@Table(name = "shop_information")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID id;
    int shop_id;
    String product_name;
    int product_quantity;
    String product_barcode;
    double product_price;
    double latitude;
    Double longitude;
}
