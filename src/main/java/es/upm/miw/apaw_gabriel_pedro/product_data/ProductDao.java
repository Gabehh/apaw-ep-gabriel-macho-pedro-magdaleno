package es.upm.miw.apaw_gabriel_pedro.product_data;
import es.upm.miw.apaw_gabriel_pedro.product_data.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDao extends MongoRepository<Product,String> {
}
