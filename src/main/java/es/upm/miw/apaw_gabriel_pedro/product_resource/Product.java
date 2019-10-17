package es.upm.miw.apaw_gabriel_pedro.product_resource;
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

    public Product(String name, String description, Double price, Supplier supplier){
        this.name = name;
        this.description = description;
        this.price = price;
        this.supplier = supplier;

    }

    public String getId(){
        return id;
    }

    public String getName(){return name;}

    public String getDescription(){return description;}

    public Double getPrice(){return price;}

    public Supplier getSupplier(){return supplier;}

    @Override
    public String toString(){
        return "Product(" +
                "id='"+id + '\''+
                ", name='"+name + '\''+
                ", description='"+description + '\''+
                ", price='"+price + '\''+
                "}";
    }

}
