package es.upm.miw.apaw_gabriel_pedro.bill_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BillResource.BILLS)
public class BillResource {

    public static final String BILLS = "/bills";

    private BillBusinessController billBusinessController;

    @Autowired
    public BillResource(BillBusinessController billBusinessController) {
        this.billBusinessController = billBusinessController;
    }

    @PostMapping
    public BillBasicDto create (@RequestBody BillCreationDto billCreationDto) {
        billCreationDto.validate();
        return this.billBusinessController.create(billCreationDto);
    }

    @GetMapping
    public List<BillGetDto> findBills() {
        return this.billBusinessController.findBills();
    }

}
