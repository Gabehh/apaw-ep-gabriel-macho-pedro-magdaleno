package es.upm.miw.apaw_gabriel_pedro.supplier_resource;
import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SupplierResource.SUPPLIERS)
public class SupplierResource {

    public static final String SUPPLIERS = "/suppliers";
    public static final String ID_ID = "/{id}";

    private SupplierBusinessController supplierBusinessController;

    @Autowired
    public SupplierResource(SupplierBusinessController supplierBusinessController){
        this.supplierBusinessController = supplierBusinessController;
    }

    @PostMapping
    public SupplierDto create (@RequestBody SupplierDto supplierDto){
        supplierDto.validate();
        return  this.supplierBusinessController.create(supplierDto);
    }

    @DeleteMapping(value = ID_ID)
    public void delete (@PathVariable String id) {
        this.supplierBusinessController.delete(id);
    }

    @PutMapping(value = ID_ID)
    public void update (@PathVariable String id, @RequestBody SupplierDto supplierDto) {
        supplierDto.validate();
        this.supplierBusinessController.update(id, supplierDto);
    }

}
