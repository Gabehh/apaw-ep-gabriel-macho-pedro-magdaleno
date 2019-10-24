package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Chef {

    @Id
    private String id;

    private String name;

    private Date starDate;

    private Date birthDate;

    public Chef(String name, Date starDate, Date birthDate)
    {
        this.name = name;
        this.starDate = starDate;
        this.birthDate = birthDate;
    }

    public String getId(){return id;}

    public String getName(){return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarDate() {
        return starDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString(){
        return "Chef(" +
                "id='"+id + '\''+
                ", name='"+name + '\''+
                ", starDate='"+starDate + '\''+
                ", birthDate='"+birthDate + '\''+
                "}";
    }

}
