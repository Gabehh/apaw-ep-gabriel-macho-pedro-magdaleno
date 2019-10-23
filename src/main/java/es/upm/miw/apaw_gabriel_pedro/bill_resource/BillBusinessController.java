package es.upm.miw.apaw_gabriel_pedro.bill_resource;

import es.upm.miw.apaw_gabriel_pedro.bill_data.Bill;
import es.upm.miw.apaw_gabriel_pedro.bill_data.BillDao;

import es.upm.miw.apaw_gabriel_pedro.product_data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BillBusinessController {

    private BillDao billDao;
    private ProductDao productDao;

    @Autowired
    public BillBusinessController(BillDao billDao, ProductDao productDao) {
        this.billDao = billDao;
        this.productDao = productDao;
    }

    public BillBasicDto create (BillCreationDto billCreationDto) {
        Bill bill = new Bill (billCreationDto.getTotal(), billCreationDto.getTotalIva(), billCreationDto.getProducts());
        this.billDao.save(bill);
        return new BillBasicDto(bill);
    }


    public List<BillGetDto> findBills(){
        return this.billDao.findAll().stream()
                .map(BillGetDto::new)
                .sorted(Comparator.comparing(BillGetDto::getDate))
                .collect(Collectors.toList());
    }

}
