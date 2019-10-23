package es.upm.miw.apaw_gabriel_pedro.waiter_resource;

import es.upm.miw.apaw_gabriel_pedro.table_data.Table;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Waiter {
    @Id
    private String id;

    private String name;

    private Date starDate;

    private Date birthDate;

    public Waiter(String name, Date starDate, Date birthDate)
    {
        this.name = name;
        this.starDate = starDate;
        this.birthDate = birthDate;
    }

    public String getId(){return id;}

    public String getName(){return name; }

    public Date getStarDate(){return starDate;}

    public Date getBirthDate(){return birthDate;}

    public String deliverFood(Table table){
        Boolean b = table.getTerrace();
        return Boolean.TRUE.equals(b) ? "Deliver food outside the restaurant" : "Deliver food inside the restaurant";
    }


    @Override
    public String toString(){
        return "Waiter(" +
                "id='"+id + '\''+
                ", name='"+name + '\''+
                ", starDate='"+starDate + '\''+
                ", birthDate='"+birthDate + '\''+
                "}";
    }

}
