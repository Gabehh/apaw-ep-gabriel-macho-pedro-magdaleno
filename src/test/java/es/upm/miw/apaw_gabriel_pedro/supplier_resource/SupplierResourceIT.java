package es.upm.miw.apaw_gabriel_pedro.supplier_resource;

import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class SupplierResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    public SupplierDto createSupplier(String value){
        return this.webTestClient
                .post().uri(SupplierResource.SUPPLIERS)
                .body(BodyInserters.fromObject(new SupplierDto(false, value, value)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SupplierDto.class).returnResult().getResponseBody();
    }

    @Test
    void testCreate() {
        testPublisherCreate("test-create-supplier");
        SupplierDto supplierDto = this.createSupplier("test-create-supplier");

        assertNotNull(supplierDto);
        assertFalse(supplierDto.getIsLocal());
        assertEquals("test-create-supplier", supplierDto.getDirection());
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

    @Test
    void testUpdate(){
        String id = this.createSupplier("test-update-supplier").getId();
        SupplierDto supplierUpdate = new SupplierDto();
        supplierUpdate.setIsLocal(true);
        supplierUpdate.setDirection("Avenue");
        supplierUpdate.setTelephone("697211047");
        this.webTestClient
                .put().uri(SupplierResource.SUPPLIERS+SupplierResource.ID_ID, id)
                .body(BodyInserters.fromObject(supplierUpdate))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateBadRequestException(){
        String id = this.createSupplier("test-update-supplier").getId();
        this.webTestClient
                .put().uri(SupplierResource.SUPPLIERS+SupplierResource.ID_ID, id)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testUpdateNotFoundException(){
        this.webTestClient
                .put().uri(SupplierResource.SUPPLIERS+SupplierResource.ID_ID, "id")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testPublisher() {
        SupplierPublish supplierPublish = new SupplierPublish();
        StepVerifier
                .create(supplierPublish.publisher())
                .then(() -> supplierPublish.setIsLocal(true))
                .expectNext("is Local?: "+true)
                .then(() -> supplierPublish.setDirection("Madrid 2-1"))
                .expectNext("Direction: Madrid 2-1")
                .then(() -> supplierPublish.setTelephone("3465417854"))
                .expectNext("Telephone: 3465417854")
                .thenCancel()
                .verify();
    }


    void testPublisherCreate(String value) {
        SupplierPublish supplierPublish = new SupplierPublish();
        StepVerifier
                .create(supplierPublish.publisher())
                .then(() -> supplierPublish.setIsLocal(true))
                .expectNext("is Local?: "+true)
                .then(() -> supplierPublish.setDirection(value))
                .expectNext("Direction: "+value)
                .then(() -> supplierPublish.setTelephone(value))
                .expectNext("Telephone: "+value)
                .thenCancel()
                .verify();
    }

}
