package es.upm.miw.apaw_gabriel_pedro.product_resource;
import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.exceptions.NotFoundException;
import es.upm.miw.apaw_gabriel_pedro.product_data.Product;
import es.upm.miw.apaw_gabriel_pedro.product_data.ProductDao;
import es.upm.miw.apaw_gabriel_pedro.supplier_data.Supplier;
import es.upm.miw.apaw_gabriel_pedro.supplier_data.SupplierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductBasicDto> findBySupplierDirection(String value){
        return this.productDao.findAll().stream()
                .filter(product -> product.getSupplier().getDirection().equalsIgnoreCase(value))
                .map(ProductBasicDto::new)
                .collect(Collectors.toList());
    }

    private Product findProductById(String id){
        return this.productDao.findById(id).orElseThrow(()-> new NotFoundException("Product id: "+ id));
    }

    private Product findAndEditProduct(String id, String name){
        Product product = findProductById(id);
        product.setName(name);
        return product;
    }

    public void update(String id, ProductCreationDto productCreationDto){
        Product product = this.findProductById(id);
        product.setDescription(productCreationDto.getDescription());
        product.setName(productCreationDto.getName());
        product.setPrice(productCreationDto.getPrice());
        if(!Strings.isNullOrEmpty(productCreationDto.getSupplierId())) {
            Supplier supplier = this.supplierDao.findById(productCreationDto.getSupplierId())
                                .orElseThrow(() -> new NotFoundException("Product id: " + productCreationDto.getSupplierId()));
            product.setSupplier(supplier);
        }
        this.productDao.save(product);
    }

    public void patch(List<ProductBasicDto> products){
        List<Product> productList = products.stream()
                .map(value -> findAndEditProduct(value.getId(),value.getName())).collect(Collectors.toList());
        this.productDao.saveAll(productList);
    }
}
