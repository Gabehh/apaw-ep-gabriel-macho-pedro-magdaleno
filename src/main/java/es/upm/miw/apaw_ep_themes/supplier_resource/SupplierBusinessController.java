package es.upm.miw.apaw_ep_themes.supplier_resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SupplierBusinessController {

    private SupplierDao supplierDao;

    @Autowired
    public SupplierBusinessController(SupplierDao supplierDao){this.supplierDao = supplierDao;}

    public SupplierDto create(SupplierDto supplierDto){
        Supplier supplier = new Supplier(supplierDto.getIsLocal(),supplierDto.getDescription(),supplierDto.getTelephone());
        this.supplierDao.save(supplier);
        return new SupplierDto(supplier);
    }
}
