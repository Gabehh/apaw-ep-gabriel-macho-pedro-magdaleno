package es.upm.miw.apaw_ep_themes.product_resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProductResource.PRODUCTS)
public class ProductResource {

    static final String PRODUCTS = "/products";
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
}
