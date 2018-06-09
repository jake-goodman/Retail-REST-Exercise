package myRetail.Models;

import org.springframework.data.annotation.Id;

public class MongoProduct {

    @Id
    public String id;

    public String productId;
    public Double price;

    public MongoProduct() {}

    public MongoProduct(String productId, Double price) {
        this.productId = productId;
        this.price = price;
    }

}
