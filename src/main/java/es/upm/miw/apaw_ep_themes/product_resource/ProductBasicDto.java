package es.upm.miw.apaw_ep_themes.product_resource;

public class ProductBasicDto {

    private String id;

    private String name;

    private String description;

    private Double price;

    public ProductBasicDto(){

    }

    public  ProductBasicDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public Double getPrice(){return price;}

    public void setPrice(Double price){this.price = price;}


    @Override
    public String toString(){
        return "ProductBasicDto(" +
                "id='"+id + '\''+
                ", name='"+name + '\''+
                ", description='"+description + '\''+
                ", price='"+price + '\''+
                "}";
    }

}
