package es.upm.miw.apaw_gabriel_pedro.table_resource;

import es.upm.miw.apaw_gabriel_pedro.bill_data.Bill;

import java.util.List;

public class TableCreationDto {

    private Integer numberOfPeople;

    private String description;

    private Boolean isTerrace;

    private List<Bill> bills;

    public TableCreationDto() {

    }

    public TableCreationDto(Integer numberOfPeople, String description, Boolean isTerrace, List<Bill> bills) {
        this.numberOfPeople = numberOfPeople;
        this.description = description;
        this.isTerrace = isTerrace;
        this.bills = bills;
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

    @Override
    public String toString() {
        return "TableCreationDto{" +
                "numberOfPeople=" + numberOfPeople + '\'' +
                ", description='" + description + '\'' +
                ", isTerrace=" + isTerrace + '\'' +
                ", bills=" + bills + '\'' +
                '}';
    }
}
