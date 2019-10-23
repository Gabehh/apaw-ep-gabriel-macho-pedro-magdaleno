package es.upm.miw.apaw_gabriel_pedro.bill_data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillDao extends MongoRepository<Bill, String> {

}
