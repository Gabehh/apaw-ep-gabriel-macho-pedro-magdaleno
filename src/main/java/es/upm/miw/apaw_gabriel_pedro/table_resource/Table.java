package es.upm.miw.apaw_gabriel_pedro.table_resource;

import es.upm.miw.apaw_gabriel_pedro.bill_resource.Bill;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Table {

    @Id
    private String id;

    private Integer numberOfPeople;

    private String description;

    private Boolean isTerrace;

    @DBRef
    private List<Bill> bills;

    public Table(Integer numberOfPeople, String description, Boolean isTerrace) {
        this.numberOfPeople = numberOfPeople;
        this.description = description;
        this.isTerrace = isTerrace;
        this.bills = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getTerrace() {
        return isTerrace;
    }

    public void setTerrace(Boolean terrace) {
        isTerrace = terrace;
    }

    public List<Bill> getBills() {
        return bills;
    }

}
