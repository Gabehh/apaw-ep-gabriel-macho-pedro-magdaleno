package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import es.upm.miw.apaw_gabriel_pedro.waiter_resource.Chef;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChefDao extends MongoRepository<Chef, String> {
}
