package es.upm.miw.apaw_gabriel_pedro.bill_resource;

import es.upm.miw.apaw_gabriel_pedro.bill_data.Bill;

import java.time.LocalDateTime;

public class BillBasicDto {

    private String id;

    private Double total;

    private LocalDateTime date;

    private Double totalIva;

    public BillBasicDto() {

    }

    public BillBasicDto(Bill bill) {
        this.id = bill.getId();
        this.total = bill.getTotal();
        this.date = bill.getDate();
        this.totalIva = bill.getTotalIva();
    }

    public String getId() {
        return id;
    }

    public Double getTotal() {
        return total;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getTotalIva() {
        return totalIva;
    }

    @Override
    public String toString() {
        return "BillBasicDto {" +
                "id='" + id + '\'' +
                ", total=" + total + '\'' +
                ", date=" + date + '\'' +
                ", totalIva=" + totalIva + '\'' +
                '}';
    }
}
