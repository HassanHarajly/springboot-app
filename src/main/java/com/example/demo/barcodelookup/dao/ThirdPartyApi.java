package com.example.demo.barcodelookup.dao;
import com.example.demo.barcodelookup.model.Product;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class ThirdPartyApi{

    private String barcode;

    ThirdPartyApi(String barcode)
    {
        this.barcode=barcode;
    }

    //using jackson json parser to map api response to Product object.
    public Product queryPopularApiForPossibleMatch() throws JSONException, IOException {
        try {
        JSONObject json = readJsonFromUrl("https://api.barcodelookup.com/v2/products?barcode="+barcode+"&formatted=y&key=5c6e4oawe75xlm0fptc6rvgr9tn4uz");
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(json.getJSONArray("products").get(0).toString(), Product.class);
            return product;
        }
        catch(Exception ex)
        {
            //todo create a logger for error handling
              System.out.println("The api Has encountered an error the barcode in question is:"+barcode);
              return new Product("","");
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
