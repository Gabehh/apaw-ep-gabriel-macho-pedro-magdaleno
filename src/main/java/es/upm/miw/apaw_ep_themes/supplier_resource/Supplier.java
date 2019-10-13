package es.upm.miw.apaw_ep_themes.supplier_resource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Supplier {
    @Id
    private String id;

    private Boolean isLocal;

    private String description;

    private String telephone;

    public Supplier(Boolean isLocal, String description, String telephone){
        this.isLocal = isLocal;
        this.description = description;
        this.telephone = telephone;
    }

    public String getId(){
        return id;
    }

    public Boolean getIsLocal(){
        return isLocal;
    }

    public String getDescription(){
        return description;
    }

    public String getTelephone(){
        return telephone;
    }

    @Override
    public String toString(){
        return "Supplier(" +
                "id='"+id + '\''+
                ", isLocal='"+isLocal + '\''+
                ", description='"+description + '\''+
                ", telephone='"+telephone + '\''+
                "}";
    }
}
