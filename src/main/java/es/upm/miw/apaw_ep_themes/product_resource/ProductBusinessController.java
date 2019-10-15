package es.upm.miw.apaw_ep_themes.product_resource;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import es.upm.miw.apaw_ep_themes.supplier_data.Supplier;
import es.upm.miw.apaw_ep_themes.supplier_data.SupplierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductBusinessController {

    private SupplierDao supplierDao;
    private ProductDao productDao;

    @Autowired
    public ProductBusinessController(SupplierDao supplierDao,ProductDao productDao){
        this.supplierDao = supplierDao;
        this.productDao = productDao;
    }

    public ProductBasicDto create (ProductCreationDto productCreationDto){
        Supplier supplier = this.supplierDao.findById(productCreationDto.getSupplierId())
                            .orElseThrow(()-> new NotFoundException("Product id: "+ productCreationDto.getSupplierId()));
        Product product = new Product(productCreationDto.getName(),productCreationDto.getDescription(), productCreationDto.getPrice(), supplier);
        this.productDao.save(product);
        return new ProductBasicDto(product);
    }
}
