package es.upm.miw.apaw_ep_themes.supplier_resource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierDao extends MongoRepository<Supplier, String> {
}
