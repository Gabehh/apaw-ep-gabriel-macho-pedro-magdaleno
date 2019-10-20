package es.upm.miw.apaw_gabriel_pedro.bill_resource;

import es.upm.miw.apaw_gabriel_pedro.exceptions.BadRequestException;
import es.upm.miw.apaw_gabriel_pedro.product_data.Product;

import java.time.LocalDateTime;
import java.util.List;

public class BillCreationDto {

    private String id;

    private Double total;

    private LocalDateTime date;

    private Double totalIva;

    private List<Product> products;

    public BillCreationDto() {

    }

    public BillCreationDto(Double total, Double totalIva, List<Product> products) {
        this.total = total;
        this.date = LocalDateTime.now();
        this.totalIva = totalIva;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void validate () {
        if(total == null || date == null || totalIva == null || products == null || products.isEmpty())  {
            throw new BadRequestException("Incomplete Bill. ");
        }
    }

    @Override
    public String toString() {
        return "BillBasicDto{" +
                "id='" + id + '\'' +
                ", total=" + total +
                ", date=" + date +
                ", totalIva=" + totalIva +
                ", products=" + products +
                '}';
    }
}
