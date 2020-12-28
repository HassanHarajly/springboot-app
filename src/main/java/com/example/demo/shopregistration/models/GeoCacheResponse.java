package com.example.demo.shopregistration.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCacheResponse {

    private List<GeoCacheResponseData> geoCacheResponseData;

    public void setData(List<GeoCacheResponseData> data){
        this.geoCacheResponseData = data;
    }
    public List<GeoCacheResponseData> getData(){
        return this.geoCacheResponseData;
    }

}
