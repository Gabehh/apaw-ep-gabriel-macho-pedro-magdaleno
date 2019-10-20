package es.upm.miw.apaw_gabriel_pedro.product_resource;

import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.exceptions.BadRequestException;

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

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public Double getPrice(){return price;}

    public void setPrice(Double price){this.price = price;}

    public String getSupplierId(){
        return supplierId;
    }

    public void setSupplierId(String supplierId){ this.supplierId = supplierId;}

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


    @Override
    public String toString(){
        return "ProductCreationDto(" +
                "name='"+name + '\''+
                ", description='"+description + '\''+
                ", price='"+price + '\''+
                ", supplierId='"+supplierId + '\''+
                "}";
    }

}
