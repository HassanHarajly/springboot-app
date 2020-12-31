package com.example.demo.shopregistration.models;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "shop_information")
@Getter
@Setter
public class Shop {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String shop_name;
    private String shop_street_address;
    private String shop_zip;
    private String shop_state;
    private double SHOP_LATITUDE;
    private double SHOP_LONGITUDE;
    @Transient
    private double distance;
    
    public Shop() {
    }



}
