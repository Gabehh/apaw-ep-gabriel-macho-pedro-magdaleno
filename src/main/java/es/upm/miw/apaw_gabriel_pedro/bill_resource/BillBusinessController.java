package es.upm.miw.apaw_gabriel_pedro.bill_resource;

import es.upm.miw.apaw_gabriel_pedro.exceptions.NotFoundException;
import es.upm.miw.apaw_gabriel_pedro.product_data.Product;
import es.upm.miw.apaw_gabriel_pedro.product_data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
        Product myProduct;
        for (int i = 0; i <= billCreationDto.getProducts().size() - 1; i++) {
            myProduct = billCreationDto.getProducts().get(i);
            Product finalMyProduct = myProduct;
            this.productDao.findById(myProduct.getId())
                    .orElseThrow(()-> new NotFoundException("Product id: "+ finalMyProduct.getId()));
        }
        Bill bill = new Bill (billCreationDto.getTotal(), billCreationDto.getTotalIva(), billCreationDto.getProducts());
        this.billDao.save(bill);
        return new BillBasicDto(bill);
    }

}
