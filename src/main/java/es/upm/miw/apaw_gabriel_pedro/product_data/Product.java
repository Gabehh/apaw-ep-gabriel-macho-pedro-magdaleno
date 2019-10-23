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

    public void setName(String name){this.name = name;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public Supplier getSupplier(){return supplier;}

    public void setSupplier(Supplier supplier){this.supplier = supplier;}

    public Double getPrice(){return price;}

    public void setPrice(Double price){this.price = price;}



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
