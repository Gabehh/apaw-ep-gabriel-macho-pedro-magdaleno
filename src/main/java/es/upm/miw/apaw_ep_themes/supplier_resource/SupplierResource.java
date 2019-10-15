package es.upm.miw.apaw_ep_themes.supplier_resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SupplierResource.SUPPLIERS)
public class SupplierResource {

    public static final String SUPPLIERS = "/suppliers";

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

}
