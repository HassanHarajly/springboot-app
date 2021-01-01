package com.example.demo.shopregistration.models;




import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shop_information")
@Getter
@Setter

public class Shop implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String shop_name;
    private String shop_street_address;
    private String shop_zip;
    private String shop_state;
    private double SHOP_LATITUDE;
    private double SHOP_LONGITUDE;
    private double distance;

    public Shop(String shop_name, String shop_street_address, String shop_zip, String shop_state, double SHOP_LATITUDE, double SHOP_LONGITUDE) {
        this.shop_name = shop_name;
        this.shop_street_address = shop_street_address;
        this.shop_zip = shop_zip;
        this.shop_state = shop_state;
        this.SHOP_LATITUDE = SHOP_LATITUDE;
        this.SHOP_LONGITUDE = SHOP_LONGITUDE;
    }

    public Shop() {
    }



}
