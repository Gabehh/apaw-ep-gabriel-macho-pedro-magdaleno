package es.upm.miw.apaw_ep_themes.product_resource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDao extends MongoRepository<Product,String> {
}
