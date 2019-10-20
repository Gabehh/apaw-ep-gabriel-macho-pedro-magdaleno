package es.upm.miw.apaw_gabriel_pedro.bill_resource;

import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import es.upm.miw.apaw_gabriel_pedro.product_data.Product;
import es.upm.miw.apaw_gabriel_pedro.product_resource.ProductBasicDto;
import es.upm.miw.apaw_gabriel_pedro.product_resource.ProductBusinessController;
import es.upm.miw.apaw_gabriel_pedro.product_resource.ProductCreationDto;
import es.upm.miw.apaw_gabriel_pedro.product_resource.ProductResource;
import es.upm.miw.apaw_gabriel_pedro.supplier_resource.SupplierDto;
import es.upm.miw.apaw_gabriel_pedro.supplier_resource.SupplierResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApiTestConfig
public class BillResourceIT {

    @Autowired
    private ProductBusinessController productBusinessController;

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

    public String createProduct(String value){
        String supplierId = this.createSupplier("test-supplier");
        return this.webTestClient
                .post().uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromObject(new ProductCreationDto(value, value,4.0,supplierId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductBasicDto.class).returnResult().getResponseBody().getId();
    }


    public BillBasicDto createBill(){
        List<Product> products = new ArrayList<Product>();
        String myProductId = this.createProduct("Hamburguer");
        Product myProduct = productBusinessController.findProductById(myProductId);
        products.add(myProduct);

        return this.webTestClient
                .post().uri(BillResource.BILLS)
                .body(BodyInserters.fromObject(new BillCreationDto(45.67, 58.54, products)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(BillBasicDto.class).returnResult().getResponseBody();
    }


    @Test
    void testCreate() {
        BillBasicDto billBasicDto = this.createBill();
        assertNotNull(billBasicDto);
    }

    @Test
    void testCreateIncompleteBill() {
        List<Product> products = new ArrayList<Product>();
        this.webTestClient
                .post().uri(BillResource.BILLS)
                .body(BodyInserters.fromObject(new BillCreationDto(null,null, products)))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateBadRequest() {
        this.webTestClient
                .post().uri(BillResource.BILLS)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
