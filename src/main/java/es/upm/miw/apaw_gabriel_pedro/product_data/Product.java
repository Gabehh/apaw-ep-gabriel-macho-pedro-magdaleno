package es.upm.miw.apaw_gabriel_pedro.product_data;
import es.upm.miw.apaw_gabriel_pedro.supplier_data.Supplier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String id;

    private String name;

    private String description;

    private Double price;

    @DBRef
    private Supplier supplier;

    public String getId(){
        return id;
    }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public Supplier getSupplier(){return supplier;}

    public void setSupplier(Supplier supplier){this.supplier = supplier;}

    public Double getPrice(){return price;}

    public void setPrice(Double price){this.price = price;}

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    @Override
    public String toString(){
        return "Product(" +
                "id='"+id + '\''+
                ", name='"+name + '\''+
                ", description='"+description + '\''+
                ", price='"+price + '\''+
                "}";
    }

    public static class ProductBuilder{

        private Product product;

        public ProductBuilder(){this.product = new Product();}

        public ProductBuilder id(String id){
            this.product.id = id;
            return this;
        }

        public ProductBuilder name(String name){
            this.product.name = name;
            return this;
        }

        public ProductBuilder description(String description){
            this.product.description = description;
            return this;
        }

        public ProductBuilder price(double price){
            this.product.price = price;
            return this;
        }

        public ProductBuilder supplier(Supplier supplier){
            this.product.supplier = supplier;
            return this;
        }

        public ProductBuilder product(Product product){
            this.product.id = product.getId();
            this.product.name = product.getName();
            this.product.description = product.getDescription();
            this.product.price = product.getPrice();
            this.product.supplier = product.getSupplier();
            return this;
        }

        public Product build(){
            return this.product;
        }
    }

}
