package es.upm.miw.apaw_gabriel_pedro.bill_resource;

import es.upm.miw.apaw_gabriel_pedro.bill_data.Bill;

import java.time.LocalDateTime;

public class BillGetDto {

    private LocalDateTime date;

    private Double totalIva;

    public BillGetDto() {

    }

    public BillGetDto(Bill bill) {
        this.date = bill.getDate();
        this.totalIva = bill.getTotalIva();
    }


    public LocalDateTime getDate() {
        return date;
    }

    public Double getTotalIva() {
        return totalIva;
    }


    @Override
    public String toString() {
        return "BillGetDto {" +
                "date=" + date + '\'' +
                ", totalIva=" + totalIva + '\'' +
                '}';
    }
}
