package es.upm.miw.apaw_gabriel_pedro.product_resource;

import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.exceptions.BadRequestException;
import es.upm.miw.apaw_gabriel_pedro.product_data.Product;

public class ProductCreationDto {

    private String name;

    private String description;

    private Double price;

    private String supplierId;

    public  ProductCreationDto(){

    }

    public  ProductCreationDto(String name, String description, Double price, String supplierId){
        this.name = name;
        this.description = description;
        this.price = price;
        this.supplierId = supplierId;
    }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getSupplierId(){
        return supplierId;
    }

    public void setSupplierId(String supplierId){ this.supplierId = supplierId;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public Double getPrice(){return price;}

    public void setPrice(Double price){this.price = price;}

    public void validateCreate(){
        if(Strings.isNullOrEmpty(description) || Strings.isNullOrEmpty(name) || price == null || Strings.isNullOrEmpty(supplierId)){
            throw new BadRequestException("Incomplete Product. ");
        }
    }

    public void validateUpdate(){
        if(Strings.isNullOrEmpty(description) || Strings.isNullOrEmpty(name) || price == null ){
            throw new BadRequestException("Incomplete Product. ");
        }
    }

    public static ProductCreationBuilder builder() {
        return new ProductCreationBuilder();
    }

    @Override
    public String toString(){
        return "ProductCreationDto(" +
                "name='"+name + '\''+
                ", description='"+description + '\''+
                ", price='"+price + '\''+
                ", supplierId='"+supplierId + '\''+
                "}";
    }

    public static class ProductCreationBuilder{

        private ProductCreationDto productCreationDto;

        public ProductCreationBuilder(){this.productCreationDto = new ProductCreationDto();}

        public ProductCreationBuilder supplierId(String supplierId){
            this.productCreationDto.supplierId = supplierId;
            return this;
        }

        public ProductCreationBuilder name(String name){
            this.productCreationDto.name = name;
            return this;
        }

        public ProductCreationBuilder description(String description){
            this.productCreationDto.description = description;
            return this;
        }

        public ProductCreationBuilder price(double price){
            this.productCreationDto.price = price;
            return this;
        }

        public ProductCreationBuilder product(Product product){
            this.productCreationDto.name = product.getName();
            this.productCreationDto.description = product.getDescription();
            this.productCreationDto.price = product.getPrice();
            this.productCreationDto.supplierId = product.getSupplier().getId();
            return this;
        }

        public ProductCreationDto build(){
            return this.productCreationDto;
        }

    }

}
