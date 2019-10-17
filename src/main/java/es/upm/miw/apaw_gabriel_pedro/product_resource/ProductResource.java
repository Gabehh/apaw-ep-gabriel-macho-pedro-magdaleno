package es.upm.miw.apaw_gabriel_pedro.product_resource;
import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ProductResource.PRODUCTS)
public class ProductResource {

    public static final String PRODUCTS = "/products";
    public static final String SEARCH = "/search";

    private ProductBusinessController productBusinessController;

    @Autowired
    public ProductResource(ProductBusinessController productBusinessController){
        this.productBusinessController = productBusinessController;
    }

    @PostMapping
    public ProductBasicDto create (@RequestBody ProductCreationDto productCreationDto){
        productCreationDto.validate();
        return this.productBusinessController.create(productCreationDto);
    }

    @GetMapping(value = SEARCH)
    public List<ProductBasicDto> find(@RequestParam String q) {
        if (Strings.isNullOrEmpty(q)) {
            throw new BadRequestException("query param q is incorrect, missing direction");
        }
        return this.productBusinessController.findBySupplierDirection(q);
    }

}
