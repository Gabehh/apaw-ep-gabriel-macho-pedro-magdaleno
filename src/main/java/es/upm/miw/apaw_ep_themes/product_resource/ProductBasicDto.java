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
