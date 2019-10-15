package es.upm.miw.apaw_ep_themes.supplier_data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Supplier {
    @Id
    private String id;

    private Boolean isLocal;

    private String direction;

    private String telephone;

    public Supplier(Boolean isLocal, String direction, String telephone){
        this.isLocal = isLocal;
        this.direction = direction;
        this.telephone = telephone;
    }

    public String getId(){
        return id;
    }

    public Boolean getIsLocal(){
        return isLocal;
    }

    public String getDirection(){ return direction; }

    public String getTelephone(){
        return telephone;
    }

    @Override
    public String toString(){
        return "Supplier(" +
                "id='"+id + '\''+
                ", isLocal='"+isLocal + '\''+
                ", direction='"+direction + '\''+
                ", telephone='"+telephone + '\''+
                "}";
    }
}
