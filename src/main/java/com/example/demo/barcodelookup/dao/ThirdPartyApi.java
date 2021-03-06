package com.example.demo.barcodelookup.dao;
import com.example.demo.barcodelookup.model.Product;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
@Component
public class ThirdPartyApi {

    @Value("${loggingUniqueIdentifier}")
    private String logID;
    Logger logger = LoggerFactory.getLogger(ThirdPartyApi.class);
    private String barcode;
    ThirdPartyApi()
    {
    }

    //using jackson json parser to map api response to Product object.
    public Product queryPopularApiForPossibleMatch(String barcode) throws JSONException, IOException {

        this.barcode=barcode;

        try {
        JSONObject json = readJsonFromUrl("https://api.barcodelookup.com/v2/products?barcode="+barcode+"&formatted=y&key=bfboxoijn4b5t7hbrqsr6yvlps0kgo");
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(json.getJSONArray("products").get(0).toString(), Product.class);
            return product;
        }
        catch(Exception ex)
        {
            //todo create a logger for error handling
            // cascade error message to controller
            logger.info(logID + "The api Has encountered an error the barcode in question is:"+barcode);
              return null;
        }


    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }


    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
