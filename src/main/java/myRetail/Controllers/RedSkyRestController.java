package myRetail.Controllers;

import myRetail.Application;
import myRetail.Models.RedSkyProduct;
import org.springframework.web.client.RestTemplate;;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedSkyRestController {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    RestTemplate restTemplate;

    public RedSkyRestController(){
        restTemplate = new RestTemplate();
    }

    public RedSkyProduct getRedSkyItem(String id){
        System.out.println("Begin /GET request!");
        String getUrl = String.format("https://redsky.target.com/v2/pdp/tcin/%s?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", id);
        RedSkyProduct item = restTemplate.getForObject(getUrl, RedSkyProduct.class);
        if (item != null) {
            log.info(item.toString());
        }
        else {
            log.debug("Failed");
        }
        return item;
    }
}