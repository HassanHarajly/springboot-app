package com.example.demo.shopregistration.models;

import com.example.demo.shopregistration.interfaces.ShopInterface;

import javax.persistence.*;

@Entity
@Table(name = "shop_information")
public class Shop implements ShopInterface {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String shop_name;
    private String shop_street_address;
    private String shop_zip;
    private String shop_state;
    private double SHOP_LATITUDE;
    private double SHOP_LONGITUDE;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    private double distance;
    public Shop() {
    }

    public double getSHOP_LATITUDE() {
        return SHOP_LATITUDE;
    }

    public void setSHOP_LATITUDE(double SHOP_LATITUDE) {
        this.SHOP_LATITUDE = SHOP_LATITUDE;
    }

    public double getSHOP_LONGITUDE() {
        return SHOP_LONGITUDE;
    }

    public void setSHOP_LONGITUDE(double SHOP_LONGITUDE) {
        this.SHOP_LONGITUDE = SHOP_LONGITUDE;
    }

    public Shop(String shop_name, String shop_street_address, String shop_zip, String shop_state) {
        this.shop_name = shop_name;
        this.shop_street_address = shop_street_address;
        this.shop_zip = shop_zip;
        this.shop_state = shop_state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_street_address() {
        return shop_street_address;
    }

    public void setShop_street_address(String shop_street_address) {
        this.shop_street_address = shop_street_address;
    }

    public String getShop_zip() {
        return shop_zip;
    }

    public void setShop_zip(String shop_zip) {
        this.shop_zip = shop_zip;
    }

    public String getShop_state() {
        return shop_state;
    }

    public void setShop_state(String shop_state) {
        this.shop_state = shop_state;
    }
}