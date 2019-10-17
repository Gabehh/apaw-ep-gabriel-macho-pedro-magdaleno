package es.upm.miw.apaw_gabriel_pedro.product_resource;

import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import es.upm.miw.apaw_gabriel_pedro.supplier_resource.SupplierDto;
import es.upm.miw.apaw_gabriel_pedro.supplier_resource.SupplierResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class ProductResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    public String CreateSuppplier(String value){
        return this.webTestClient
                .post().uri(SupplierResource.SUPPLIERS)
                .body(BodyInserters.fromObject(new SupplierDto(false,value,value)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SupplierDto.class).returnResult().getResponseBody().getId();
    }

    @Test
    void testCreateProduct() {
        String supplierId = this.CreateSuppplier("testSupplier");
        ProductBasicDto productBasicDto = this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("Hambuger", "It has cheese",2323.0232,supplierId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductBasicDto.class).returnResult().getResponseBody();
        assertNotNull(productBasicDto);
        assertEquals("It has cheese", productBasicDto.getDescription());
    }

    @Test
    void testCreateProductException() {
        String supplierId = this.CreateSuppplier("testSupplier");
        this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("", "",null,supplierId)))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testSearch() {
        String supplierId = this.CreateSuppplier("Burger King 2-1");
        this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("Big Hamburger", "It has cheese",5.0,supplierId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductBasicDto.class).returnResult().getResponseBody();
        this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("Small Burger", "It hasn't got cheese",2.0,supplierId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductBasicDto.class).returnResult().getResponseBody();
        List<ProductBasicDto> products = this.webTestClient
                .get().uri(uriBuilder -> uriBuilder.path(ProductResource.PRODUCTS+ProductResource.SEARCH)
                .queryParam("q","Burger King 2-1")
                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ProductBasicDto.class)
                .returnResult().getResponseBody();
        assertTrue(products.size() > 0);
        assertNotNull(products.get(0).getDescription());
    }

    @Test
    void testSearchException() {
        String supplierId = this.CreateSuppplier("Burger King 2-1");
        this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("Big Hamburger", "It has cheese",5.0,supplierId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductBasicDto.class).returnResult().getResponseBody();
        this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("Small Burger", "It hasn't got cheese",2.0,supplierId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductBasicDto.class).returnResult().getResponseBody();
         this.webTestClient
                .get().uri(uriBuilder -> uriBuilder.path(ProductResource.PRODUCTS+ProductResource.SEARCH)
                .queryParam("q","")
                .build())
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
