package com.example.demo.barcodelookup.model;

public class Product {
    public String Name;
    long barCode;

    public Product(String name,long barCode) {
        Name = name;
        this.barCode=barCode;
    }
}
