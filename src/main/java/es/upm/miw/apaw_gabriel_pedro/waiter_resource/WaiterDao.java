package es.upm.miw.apaw_gabriel_pedro.waiter_resource;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WaiterDao extends MongoRepository<Waiter, String> {
}
