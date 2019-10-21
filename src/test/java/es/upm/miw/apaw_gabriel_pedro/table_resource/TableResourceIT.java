package es.upm.miw.apaw_gabriel_pedro.table_resource;

import es.upm.miw.apaw_gabriel_pedro.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ApiTestConfig

public class TableResourceIT {


    @Autowired
    private WebTestClient webTestClient;

    public TableBasicDto createTable() {
        return this.webTestClient
                .post().uri(TableResource.TABLES)
                .body(BodyInserters.fromObject(new TableCreationDto(5, "Mesa numero 5",true)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(TableBasicDto.class).returnResult().getResponseBody();
    }

    @Test
    void testCreateTable() {
        TableBasicDto tableBasicDto = this.createTable();
        assertNotNull(tableBasicDto);
    }

    private void assertNotNull(TableBasicDto tableBasicDto) {
    }

    @Test
    void testCreateIncompleteTable() {
        this.webTestClient
                .post().uri(TableResource.TABLES)
                .body(BodyInserters.fromObject(new TableCreationDto(null, null, null)))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateBadRequest() {
        this.webTestClient
                .post().uri(TableResource.TABLES)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }


}
