package com.example.demo.shopregistration.services;

import com.example.demo.shopregistration.models.GeoCacheResponse;
import org.springframework.web.client.RestTemplate;

public class GeoCacheApiService {
    //todo add api key to a more secure place like github credentials.
    private String positionStackGeoCacheUrl="http://api.positionstack.com/v1/forward?access_key=5eede26621f25ae287cc4c6a50b136d9"
           ;
    RestTemplate restTemplate = new RestTemplate();

    public GeoCacheResponse getApiResponse(String address)
    {
        String URL = positionStackGeoCacheUrl + "&query="+address+"country=usa";
        GeoCacheResponse data = restTemplate
                .getForObject(URL, GeoCacheResponse.class);

        return data;
    }
}
