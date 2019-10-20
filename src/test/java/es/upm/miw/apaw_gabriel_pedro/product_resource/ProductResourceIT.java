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

    public String createSupplier(String value){
        return this.webTestClient
                .post().uri(SupplierResource.SUPPLIERS)
                .body(BodyInserters.fromObject(new SupplierDto(false,value,value)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SupplierDto.class).returnResult().getResponseBody().getId();
    }

    public ProductBasicDto createProduct(String value){
        String supplierId = this.createSupplier("test-supplier");
        return this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto(value, value,4.0,supplierId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductBasicDto.class).returnResult().getResponseBody();
    }

    @Test
    void testCreate() {
        ProductBasicDto productBasicDto = this.createProduct("Hamburger");
        assertNotNull(productBasicDto);
        assertEquals("Hamburger", productBasicDto.getDescription());
    }

    @Test
    void testCreateProductIncomplete() {
        String supplierId = this.createSupplier("test-supplier");
        this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("", "",null,supplierId)))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateBadRequest() {
        this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testSearch() {
        String supplierId = this.createSupplier("Burger King 2-1");
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
    void testSearchBadRequest() {
        String firstSupplierId = this.createSupplier("Burger King 2-1");
        String secondSupplierId = this.createSupplier("McDonald's");
        this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("Big Hamburger", "It has cheese",5.0,firstSupplierId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductBasicDto.class).returnResult().getResponseBody();
        this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto("Small Burger", "It hasn't got cheese",2.0,secondSupplierId)))
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

    @Test
    void testSearchEmpty() {
        List<ProductBasicDto> products = this.webTestClient
                .get().uri(uriBuilder -> uriBuilder.path(ProductResource.PRODUCTS+ProductResource.SEARCH)
                        .queryParam("q","Burger King 2-1")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ProductBasicDto.class)
                .returnResult().getResponseBody();
        assertTrue(products.size() == 0);
    }

    @Test
    void testUpdate(){
        String id = this.createProduct("Hamburger").getId();
        String newDirection = this.createSupplier("Park Avenue 1-2, London");
        ProductUpdateDto productUpdateDto = new ProductUpdateDto();
        productUpdateDto.setName("New Hamburger");
        productUpdateDto.setDescription("It has cheese");
        productUpdateDto.setPrice(5.0);
        productUpdateDto.setSupplierId(newDirection);
        this.webTestClient
                .put().uri(ProductResource.PRODUCTS+ProductResource.ID_ID, id)
                .body(BodyInserters.fromObject(productUpdateDto))
                .exchange()
                .expectStatus().isOk();
        List<ProductBasicDto> products = this.webTestClient
                .get().uri(uriBuilder -> uriBuilder.path(ProductResource.PRODUCTS+ProductResource.SEARCH)
                        .queryParam("q","Park Avenue 1-2, London")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ProductBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals(id,products.get(0).getId());
        assertEquals("New Hamburger",products.get(0).getName());
    }

    @Test
    void testUpdateNotFoundException(){
        String id = this.createProduct("Hamburger").getId();
        this.webTestClient
                .put().uri(ProductResource.PRODUCTS+ProductResource.ID_ID, id)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testUpdateBadRequestException(){
        this.webTestClient
                .put().uri(ProductResource.PRODUCTS+ProductResource.ID_ID, "xxx")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
