package com.example.demo.barcodelookup.model;

public class Product {
    private String Name;
    private String barCode;

    public Product(String name,String barCode) {
        Name = name;
        this.barCode=barCode;
    }
    public String getProductBarcode()
    {
        return barCode;
    }

    public String getProductName()
    {
        return Name;
    }
}
