package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.test.StepVerifier;

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

    void testPublisher() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1995);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date starDate = cal.getTime();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 4);
        Date birthDate = cal.getTime();

        ChefPublish chefPublish = new ChefPublish();

        StepVerifier
                .create(chefPublish.publisher())
                .then(() -> chefPublish.create("test-create-chef", starDate, birthDate))
                .expectNext("name: test-create-chef" + " " + "starDate: "+ starDate + " " + "birthDate: "+ birthDate)
                .thenCancel()
                .verify();
    }

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

        testPublisher();

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
                .body(BodyInserters.fromObject(new ChefDto("test-create-chef", starDate, birthDate)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ChefDto.class).returnResult().getResponseBody();
        assertNotNull(chefDto);
        assertEquals("test-create-chef", chefDto.getName());
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

    @Test
    void testComposite() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1995);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date starDate = cal.getTime();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 4);
        Date birthDate = cal.getTime();

        Chef chefA = new Chef("hoja A", starDate, birthDate);
        Chef chefB = new Chef("hoja B", starDate, birthDate);
        Chef chefXA = new Chef("hoja XA", starDate, birthDate);
        Chef chefXB = new Chef("hoja XB", starDate, birthDate);
        Chef chefC = new Chef("hoja C", starDate, birthDate);
        Chef chefD = new Chef("hoja D", starDate, birthDate);

        TreeChefsComposite comp1 = new TreeChefsComposite("composite1", "composite1", starDate, birthDate);
        comp1.add(new TreeChefsLeaf(chefA));
        comp1.add(new TreeChefsLeaf(chefB));
        TreeChefsComposite comp2 = new TreeChefsComposite("composite2", "composite2", starDate, birthDate);
        comp2.add(new TreeChefsLeaf(chefXA));
        comp2.add(new TreeChefsLeaf(chefXB));
        comp1.add(comp2);
        comp1.add(new TreeChefsLeaf(chefC));
        TreeChefsLeaf l = new TreeChefsLeaf(chefD);
        comp1.add(l);
        comp1.remove(l);

        assertEquals("composite1", comp1.id());
        assertEquals("composite1", comp1.name());
        assertEquals(starDate, comp1.starDate());
        assertEquals(birthDate, comp1.birthDate());
        assertEquals("hoja D", l.name());
        assertEquals(starDate, l.starDate());
        assertEquals(birthDate, l.birthDate());

    }

}
