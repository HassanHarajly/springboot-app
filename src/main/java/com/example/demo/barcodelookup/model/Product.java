package com.example.demo.barcodelookup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private String product_name;
    private String barcode_number;

    public Product(){}
    public Product(String name,String barCode) {
        product_name = name;
        this.barcode_number=barCode;
    }



    public String getProductBarcode()
    {
        return barcode_number;
    }

    public String getProductName()
    {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public void setBarcode_number(String barcode_number) {
        this.barcode_number = barcode_number;
    }
}
