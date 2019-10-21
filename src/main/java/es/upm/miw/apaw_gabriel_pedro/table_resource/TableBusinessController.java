package es.upm.miw.apaw_gabriel_pedro.table_resource;

import es.upm.miw.apaw_gabriel_pedro.bill_data.BillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TableBusinessController {

    private TableDao tableDao;
    private BillDao billDao;

    @Autowired
    public TableBusinessController(TableDao tableDao, BillDao billDao) {
        this.tableDao = tableDao;
        this.billDao = billDao;
    }

    public TableBasicDto create (TableCreationDto tableCreationDto) {
        Table table = new Table(tableCreationDto.getNumberOfPeople(), tableCreationDto.getDescription(), tableCreationDto.getTerrace());
        this.tableDao.save(table);
        return new TableBasicDto(table);
    }

}
