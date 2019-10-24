package es.upm.miw.apaw_gabriel_pedro.product_resource;

import es.upm.miw.apaw_gabriel_pedro.product_data.Product;

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

    public Double getPrice(){return price;}

    public void setPrice(Double price){this.price = price;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public static ProductBasicBuilder builder() {
        return new ProductBasicBuilder();
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

    public static class ProductBasicBuilder{

        private ProductBasicDto productBasicDto;

        public ProductBasicBuilder(){this.productBasicDto = new ProductBasicDto();}

        public ProductBasicBuilder id(String id){
            this.productBasicDto.id = id;
            return this;
        }

        public ProductBasicBuilder name(String name){
            this.productBasicDto.name = name;
            return this;
        }

        public ProductBasicBuilder description(String description){
            this.productBasicDto.description = description;
            return this;
        }

        public ProductBasicBuilder product(Product product){
            this.productBasicDto.id = product.getId();
            this.productBasicDto.name = product.getName();
            this.productBasicDto.description = product.getDescription();
            this.productBasicDto.price = product.getPrice();
            return this;
        }

        public ProductBasicBuilder price(double price){
            this.productBasicDto.price = price;
            return this;
        }

        public ProductBasicDto build(){
            return this.productBasicDto;
        }

    }

}
