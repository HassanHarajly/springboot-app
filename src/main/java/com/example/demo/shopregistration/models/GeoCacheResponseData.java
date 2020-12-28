package com.example.demo.shopregistration.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("data")
    public class GeoCacheResponseData
    {
        private double latitude;

        private double longitude;

        public void setLatitude(double latitude){
            this.latitude = latitude;
        }
        public double getLatitude(){
            return this.latitude;
        }
        public void setLongitude(double longitude){
            this.longitude = longitude;
        }
        public double getLongitude(){
            return this.longitude;
        }

}
