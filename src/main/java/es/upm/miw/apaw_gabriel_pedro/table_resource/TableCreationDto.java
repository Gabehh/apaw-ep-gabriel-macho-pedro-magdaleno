package es.upm.miw.apaw_gabriel_pedro.table_resource;

import com.google.common.base.Strings;
import es.upm.miw.apaw_gabriel_pedro.bill_data.Bill;
import es.upm.miw.apaw_gabriel_pedro.exceptions.BadRequestException;

import java.util.ArrayList;
import java.util.List;

public class TableCreationDto {

    private Integer numberOfPeople;

    private String description;

    private Boolean isTerrace;

    private List<Bill> bills;

    public TableCreationDto() {

    }

    public TableCreationDto(Integer numberOfPeople, String description, Boolean isTerrace) {
        this.numberOfPeople = numberOfPeople;
        this.description = description;
        this.isTerrace = isTerrace;
        this.bills = new ArrayList<>();
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

    public void setTerrace(Boolean terrace) { this.isTerrace = terrace; }

    public List<Bill> getBills() {
        return bills;
    }

    public void validate() {
        if (numberOfPeople == null || Strings.isNullOrEmpty(description) || isTerrace == null || bills == null) {
            throw new BadRequestException("Incomplete Table. ");
        }
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
