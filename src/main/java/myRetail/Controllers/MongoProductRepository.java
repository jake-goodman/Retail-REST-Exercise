package myRetail.Controllers;

import myRetail.Models.MongoProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

interface MongoProductRepository extends MongoRepository<MongoProduct, String> {

    public MongoProduct findByProductId(String productId);

}