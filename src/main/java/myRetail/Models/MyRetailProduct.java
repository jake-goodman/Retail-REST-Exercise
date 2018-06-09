package myRetail.Models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyRetailProduct {

    public String id;
    public String title;
    public Double price;

    public MyRetailProduct() {};
    public MyRetailProduct(String id, String title, Double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }


    public String getId() { return id; }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

}
