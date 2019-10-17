package es.upm.miw.apaw_gabriel_pedro.supplier_resource;
import es.upm.miw.apaw_gabriel_pedro.exceptions.BadRequestException;
import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.supplier_data.Supplier;

public class SupplierDto {
    private String id;

    private Boolean isLocal;

    private String direction;

    private String telephone;

    public SupplierDto() {
        // empty for framework
    }
    public SupplierDto(Boolean isLocal, String direction, String telephone){
        this.isLocal = isLocal;
        this.direction = direction;
        this.telephone = telephone;
    }

    public SupplierDto(Supplier supplier){
        this.id = supplier.getId();
        this.direction = supplier.getDirection();
        this.isLocal = supplier.getIsLocal();
        this.telephone = supplier.getTelephone();
    }

    public void validate(){
        if(Strings.isNullOrEmpty(direction) || Strings.isNullOrEmpty(telephone) || isLocal == null){
            throw new BadRequestException("Incomplete SupplierDto. ");
        }
    }

    public String getId(){return id;}

    public void setId(String id){
        this.id = id;
    }

    public Boolean getIsLocal(){return isLocal;}

    public void setIsLocal(Boolean isLocal){
        this.isLocal = isLocal;
    }

    public String getDirection(){return  direction;}

    public void setDirection(String description){
        this.direction = description;
    }

    public String getTelephone(){return  telephone;}

    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    @Override
    public String toString(){
        return "SupplierDto(" +
                "id='"+id + '\''+
                ", isLocal='"+isLocal + '\''+
                ", description='"+direction + '\''+
                ", telephone='"+telephone + '\''+
                "}";
    }
}
