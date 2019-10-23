package es.upm.miw.apaw_gabriel_pedro.waiter_resource;

import es.upm.miw.apaw_gabriel_pedro.table_data.Table;
import org.springframework.data.annotation.Id;

import java.util.Date;

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
