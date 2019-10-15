package es.upm.miw.apaw_ep_themes.product_resource;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.supplier_resource.SupplierDto;
import es.upm.miw.apaw_ep_themes.supplier_resource.SupplierResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class ProductResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        String supplierId = this.webTestClient
                .post().uri(SupplierResource.SUPPLIERS)
                .body(BodyInserters.fromObject(new SupplierDto(false,"Street London 12-3","+34685615119")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SupplierDto.class).returnResult().getResponseBody().getId();
        ProductBasicDto productBasicDto = this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("Hambuger", "It has cheese",2323.0232,supplierId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductBasicDto.class).returnResult().getResponseBody();
        assertNotNull(productBasicDto);
    }
}
