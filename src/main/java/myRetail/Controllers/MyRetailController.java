package myRetail.Controllers;

import myRetail.Models.MongoProduct;
import myRetail.Models.MyRetailProduct;
import myRetail.Models.RedSkyProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


@RestController
public class MyRetailController {
    @Autowired
    private MongoProductRepository repository;
    private RedSkyRestController redSkyClient = new RedSkyRestController();

    @PostConstruct
    public void preloadMongoProductDatabase() {
        repository.deleteAll();
        repository.save(new MongoProduct("13860428", 19.98));
        repository.save(new MongoProduct("16696652", 39.0));
        repository.save(new MongoProduct("13860429", 12.98));
        repository.save(new MongoProduct("13860327", 9.69));
        repository.save(new MongoProduct("16696651", 26.0));
    }

    @GetMapping(path = "/product/{id}")
    public ResponseEntity<MyRetailProduct> product(@PathVariable String id) {
        MongoProduct mongoProduct = repository.findByProductId(id);
        RedSkyProduct redSkyProduct = redSkyClient.getRedSkyItem(id);
        HttpHeaders responseHeaders = new HttpHeaders();

        if (mongoProduct == null && redSkyProduct == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MyRetailProduct product = new MyRetailProduct();
        if (redSkyProduct != null) {
            product.title = redSkyProduct.title;
        }
        if (mongoProduct != null) {
            product.price = mongoProduct.price;
        }
        return new ResponseEntity<>(product, responseHeaders, HttpStatus.OK);
    }

    @PutMapping(path = "/product/{id}")
    public ResponseEntity<MyRetailProduct> product(@PathVariable String id,
                                                   @RequestParam("price") Double price) {

        MongoProduct mongoProduct = repository.findByProductId(id);
         if (mongoProduct != null) {
             mongoProduct.price = price;
             repository.save(mongoProduct);
         }
         else {
             repository.save(new MongoProduct(id, price));
         }

         return product(id);

    }


}
