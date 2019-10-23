package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChefDao extends MongoRepository<Chef, String> {
}
