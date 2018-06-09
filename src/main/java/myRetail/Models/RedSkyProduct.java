package myRetail.Models;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RedSkyProduct {

    public String title;

    @JsonProperty("product")
    private void unpackNested(Map<String,Object> product) {
        Map<String,Object> item = (Map<String,Object>)product.get("item");
        Map<String,String> product_description = (Map<String,String>)item.get("product_description");
        title =  product_description.get("title");
    }

    public String toString() {
        return String.format("Item Info: name = %s", title);
    }


}

