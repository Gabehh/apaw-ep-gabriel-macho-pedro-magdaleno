package es.upm.miw.apaw_gabriel_pedro.table_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TableResource.TABLES)
public class TableResource {

    public static final String TABLES = "/tables";

    private TableBusinessController tableBusinessController;

    @Autowired
    public TableResource(TableBusinessController tableBusinessController) {
        this.tableBusinessController = tableBusinessController;
    }

    @PostMapping
    public TableBasicDto creation (@RequestBody TableCreationDto tableCreationDto) {
        tableCreationDto.validate();
        return this.tableBusinessController.create(tableCreationDto);
    }

}
