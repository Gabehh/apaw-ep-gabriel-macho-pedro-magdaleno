package es.upm.miw.apaw_gabriel_pedro.supplier_resource;
import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.exceptions.NotFoundException;
import es.upm.miw.apaw_gabriel_pedro.supplier_data.Supplier;
import es.upm.miw.apaw_gabriel_pedro.supplier_data.SupplierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SupplierBusinessController {

    private SupplierDao supplierDao;

    @Autowired
    public SupplierBusinessController(SupplierDao supplierDao){this.supplierDao = supplierDao;}

    public SupplierDto create(SupplierDto supplierDto){
        Supplier supplier = new Supplier(supplierDto.getIsLocal(),supplierDto.getDirection(),supplierDto.getTelephone());
        this.supplierDao.save(supplier);
        return new SupplierDto(supplier);
    }

    public void delete(String id){
        Supplier supplier = this.supplierDao.findById(id)
                .orElseThrow(()-> new NotFoundException("Supplier id: "+ id));
        this.supplierDao.delete(supplier);
    }

    public Supplier findProductById(String id){
        return this.supplierDao.findById(id).orElseThrow(()-> new NotFoundException("Supplier id: "+ id));
    }

    public void update(String id, SupplierDto supplierDto){
        Supplier supplier = this.findProductById(id);
        supplier.setLocal(supplierDto.getIsLocal());
        supplier.setDirection(supplierDto.getDirection());
        supplier.setTelephone(supplierDto.getTelephone());
        this.supplierDao.save(supplier);
    }

}
