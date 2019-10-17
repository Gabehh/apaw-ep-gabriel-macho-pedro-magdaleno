package es.upm.miw.apaw_gabriel_pedro.product_resource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDao extends MongoRepository<Product,String> {
}
