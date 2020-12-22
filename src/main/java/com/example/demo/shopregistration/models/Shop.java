package com.example.demo.shopregistration.models;

public class Shop {
    private int id;
    private String shop_name;
    private String shop_street_address;
    private String shop_zip;
    private String shop_state;

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
