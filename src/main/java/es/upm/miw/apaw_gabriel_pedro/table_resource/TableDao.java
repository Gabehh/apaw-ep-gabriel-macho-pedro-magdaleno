package es.upm.miw.apaw_gabriel_pedro.table_resource;

import es.upm.miw.apaw_gabriel_pedro.table_data.Table;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TableDao extends MongoRepository<Table, String> {
}
