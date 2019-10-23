package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.exceptions.BadRequestException;

import java.util.Date;

public class ChefDto {

    private String id;

    private String name;

    private Date starDate;

    private Date birthDate;

    public ChefDto(){

    }

    public ChefDto(String name, Date starDate, Date birthDate)
    {
        this.name = name;
        this.starDate = starDate;
        this.birthDate = birthDate;
    }

    public ChefDto(Chef chef){
        this.id = chef.getId();
        this.name = chef.getName();
        this.birthDate = chef.getBirthDate();
        this.starDate = chef.getStarDate();
    }

    public void validate(){
        if(Strings.isNullOrEmpty(name) || birthDate == null || starDate == null){
            throw new BadRequestException("Incomplete ChefDto. ");
        }
    }

    public String getId(){return id;}

    public String getName(){return name; }

    public void setName(String name){this.name = name;}

    public Date getStarDate(){return starDate;}

    public Date getBirthDate(){return birthDate;}

    @Override
    public String toString(){
        return "ChefDto(" +
                "id='"+id + '\''+
                ", name='"+name + '\''+
                ", starDate='"+starDate + '\''+
                ", birthDate='"+birthDate + '\''+
                "}";
    }
}
