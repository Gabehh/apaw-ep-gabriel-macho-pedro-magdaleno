package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

@ApiTestConfig
public class ChefResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ChefSeeder chefSeeder;

    @Test
    void testPatch(){
        this.webTestClient
            .patch().uri(uriBuilder -> uriBuilder.path(ChefResource.CHEFS)
                .queryParam("oldName","Francisco")
                .queryParam("newName","Paco")
                .build())
             .exchange()
             .expectStatus().isEqualTo(HttpStatus.OK);
    }

}
