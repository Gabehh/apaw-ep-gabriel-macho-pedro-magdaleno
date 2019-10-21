package es.upm.miw.apaw_gabriel_pedro.waiter_resource;

import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.exceptions.BadRequestException;

import java.util.Date;

public class WaiterDto {
    private String id;

    private String name;

    private Date starDate;

    private Date birthDate;

    public WaiterDto(){

    }

    public WaiterDto(String name, Date starDate, Date birthDate)
    {
        this.name = name;
        this.starDate = starDate;
        this.birthDate = birthDate;
    }

    public WaiterDto(Waiter waiter){
        this.id = waiter.getId();
        this.name = waiter.getName();
        this.birthDate = waiter.getBirthDate();
        this.starDate = waiter.getStarDate();
    }

    public void validate(){
        if(Strings.isNullOrEmpty(name) || birthDate == null || starDate == null){
            throw new BadRequestException("Incomplete WaiterDto. ");
        }
    }

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getName(){return name; }

    public void setName(String name){this.name = name;}

    public Date getStarDate(){return starDate;}

    public void setStarDate(Date starDate){this.starDate = starDate;}

    public Date getBirthDate(){return birthDate;}

    public void setBirthDate(Date birthDate){this.birthDate = birthDate;}

    @Override
    public String toString(){
        return "WaiterDto(" +
                "id='"+id + '\''+
                ", name='"+name + '\''+
                ", starDate='"+starDate + '\''+
                ", birthDate='"+birthDate + '\''+
                "}";
    }
}
