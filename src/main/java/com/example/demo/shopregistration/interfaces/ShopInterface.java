package com.example.demo.shopregistration.interfaces;

public interface ShopInterface {
    int id = 0;
    String shop_name = null;
    String shop_street_address = null;
    String shop_zip = null;
    String shop_state = null;

    public int getId();

    public void setId(int id);

    public String getShop_name();


    public void setShop_name(String shop_name);

    public String getShop_street_address();

    public void setShop_street_address(String shop_street_address);

    public String getShop_zip();

    public void setShop_zip(String shop_zip);

    public String getShop_state();

    public void setShop_state(String shop_state);
}
