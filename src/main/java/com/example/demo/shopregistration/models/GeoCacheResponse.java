package com.example.demo.shopregistration.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCacheResponse {

    private List<data> data;

    public void setData(List<data> data){
        this.data = data;
    }
    public List<data> getData(){
        return this.data;
    }

}
