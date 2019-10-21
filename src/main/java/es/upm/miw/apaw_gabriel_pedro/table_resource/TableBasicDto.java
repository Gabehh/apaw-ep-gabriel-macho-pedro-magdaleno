package es.upm.miw.apaw_gabriel_pedro.table_resource;

import es.upm.miw.apaw_gabriel_pedro.bill_data.Bill;

import java.util.List;

public class TableBasicDto {

    private String id;

    private Integer numberOfPeople;

    private String description;

    private Boolean isTerrace;

    public TableBasicDto() {

    }

    public TableBasicDto(Table table) {
        this.id = table.getId();
        this.numberOfPeople = table.getNumberOfPeople();
        this.description = table.getDescription();
        this.isTerrace = table.getTerrace();
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

    @Override
    public String toString() {
        return "TableBasicDto{" +
                "id='" + id + '\'' +
                ", numberOfPeople=" + numberOfPeople + '\'' +
                ", description='" + description + '\'' +
                ", isTerrace=" + isTerrace + '\'' +
                '}';
    }
}
