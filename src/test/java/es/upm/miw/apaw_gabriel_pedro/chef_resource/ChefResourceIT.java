package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    void testCreate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1995);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date starDate = cal.getTime();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 4);
        Date birthDate = cal.getTime();

        ChefDto chefDto = this.webTestClient
                .post().uri(ChefResource.CHEFS)
                .body(BodyInserters.fromObject(new ChefDto("Jaime", starDate, birthDate)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ChefDto.class).returnResult().getResponseBody();
        assertNotNull(chefDto);
        assertEquals("Jaime", chefDto.getName());
    }

    @Test
    void testCreateChefIncomplete() {
        this.webTestClient
                .post().uri(ChefResource.CHEFS)
                .body(BodyInserters.fromObject(new ChefDto("Marcos", null, null)))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateBadRequest() {
        this.webTestClient
                .post().uri(ChefResource.CHEFS)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
