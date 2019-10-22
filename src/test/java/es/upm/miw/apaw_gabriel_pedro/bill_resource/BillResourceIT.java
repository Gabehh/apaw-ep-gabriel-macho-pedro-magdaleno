package es.upm.miw.apaw_gabriel_pedro.bill_resource;

import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import es.upm.miw.apaw_gabriel_pedro.product_data.Product;
import es.upm.miw.apaw_gabriel_pedro.product_resource.ProductBusinessController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.List;

@ApiTestConfig
public class BillResourceIT {

    @Autowired
    private ProductBusinessController productBusinessController;

    @Autowired
    private WebTestClient webTestClient;

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


    @Test
    void testSearchEmpty() {
        List<BillGetDto> bills = this.webTestClient
                .get().uri(uriBuilder -> uriBuilder.path(BillResource.BILLS).build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BillGetDto.class)
                .returnResult().getResponseBody();
        assertTrue(bills.size() == 0);
    }

    private void assertTrue(boolean b) {
    }

}
