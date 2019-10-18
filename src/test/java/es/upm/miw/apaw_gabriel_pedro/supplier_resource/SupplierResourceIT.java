package es.upm.miw.apaw_gabriel_pedro.supplier_resource;

import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class SupplierResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        SupplierDto supplierDto = this.webTestClient
                .post().uri(SupplierResource.SUPPLIERS)
                .body(BodyInserters.fromObject(new SupplierDto(false,"Park Avenue 12-3","+34685615119")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SupplierDto.class).returnResult().getResponseBody();
        assertNotNull(supplierDto);
        assertFalse(supplierDto.getIsLocal());
        assertEquals("Park Avenue 12-3", supplierDto.getDirection());
    }

    @Test
    void testCreateSupplierException() {
        SupplierDto suggestionDto = new SupplierDto(null, "test","");
        this.webTestClient
                .post().uri(SupplierResource.SUPPLIERS)
                .body(BodyInserters.fromObject(suggestionDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateCreateSupplierException() {
        SupplierDto suggestionDto = new SupplierDto(false, null,"+34685615119");
        this.webTestClient
                .post().uri(SupplierResource.SUPPLIERS)
                .body(BodyInserters.fromObject(suggestionDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void deleteSupplier(){
        String idSupplier = this.webTestClient
                .post().uri(SupplierResource.SUPPLIERS)
                .body(BodyInserters.fromObject(new SupplierDto(false,"Park Avenue 12-3","+34685615119")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SupplierDto.class).returnResult().getResponseBody().getId();
        this.webTestClient
                .delete().uri(SupplierResource.SUPPLIERS + SupplierResource.ID_ID, idSupplier)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void deleteSupplierException(){
        this.webTestClient
                .delete().uri(SupplierResource.SUPPLIERS + SupplierResource.ID_ID, "")
                .exchange()
                .expectStatus()
                .isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
