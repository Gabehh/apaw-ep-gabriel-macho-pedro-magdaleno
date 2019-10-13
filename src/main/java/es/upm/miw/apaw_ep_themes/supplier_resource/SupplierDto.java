package es.upm.miw.apaw_ep_themes.supplier_resource;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import com.google.common.base.Strings;

public class SupplierDto {
    private String id;

    private Boolean isLocal;

    private String description;

    private String telephone;

    public SupplierDto() {
        // empty for framework
    }
    public SupplierDto(Boolean isLocal, String description, String telephone){
        this.isLocal = isLocal;
        this.description = description;
        this.telephone = telephone;
    }

    public SupplierDto(Supplier supplier){
        this.id = supplier.getId();
        this.description = supplier.getDescription();
        this.isLocal = supplier.getIsLocal();
        this.telephone = supplier.getTelephone();
    }

    public void validate(){
        if(Strings.isNullOrEmpty(description) || Strings.isNullOrEmpty(telephone) || isLocal == null){
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

    public String getDescription(){return  description;}

    public void setDescription(String description){
        this.description = description;
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
                ", description='"+description + '\''+
                ", telephone='"+telephone + '\''+
                "}";
    }
}
