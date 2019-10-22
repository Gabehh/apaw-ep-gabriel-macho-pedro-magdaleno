package es.upm.miw.apaw_gabriel_pedro.waiter_resource;

import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

@ApiTestConfig
public class WaiterResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        WaiterDto waiterDto = this.webTestClient
                .post().uri(WaiterResource.WAITERS)
                .body(BodyInserters.fromObject(new WaiterDto("Luis",new Date(2019,1,4),new Date(1995,2,2))))
                .exchange()
                .expectStatus().isOk()
                .expectBody(WaiterDto.class).returnResult().getResponseBody();
        assertNotNull(waiterDto);
        assertEquals("Luis", waiterDto.getName());
    }

    @Test
    void testCreateWaiterIncomplete() {
        this.webTestClient
                .post().uri(WaiterResource.WAITERS)
                .body(BodyInserters.fromObject(new WaiterDto("Luis",null,new Date(1995,2,2))))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateBadRequest() {
        this.webTestClient
                .post().uri(WaiterResource.WAITERS)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void deleteWaiter(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1995);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date starDate = cal.getTime();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 4);
        Date birthDate = cal.getTime();

        String idWaiter = this.webTestClient
                .post().uri(WaiterResource.WAITERS)
                .body(BodyInserters.fromObject(new WaiterDto("Luis", starDate, birthDate)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(WaiterDto.class).returnResult().getResponseBody().getId();
        this.webTestClient
                .delete().uri(WaiterResource.WAITERS + WaiterResource.ID_ID, idWaiter)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void deleteSupplierException(){
        this.webTestClient
                .delete().uri(WaiterResource.WAITERS + WaiterResource.ID_ID, "")
                .exchange()
                .expectStatus()
                .isEqualTo(HttpStatus.BAD_REQUEST);
    }


}
