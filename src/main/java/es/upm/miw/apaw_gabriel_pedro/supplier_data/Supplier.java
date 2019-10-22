package es.upm.miw.apaw_gabriel_pedro.supplier_data;
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

    public void setLocal(Boolean local) {
        isLocal = local;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
