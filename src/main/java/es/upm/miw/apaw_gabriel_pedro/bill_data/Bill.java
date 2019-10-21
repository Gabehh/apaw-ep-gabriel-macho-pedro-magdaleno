package es.upm.miw.apaw_gabriel_pedro.bill_data;

import es.upm.miw.apaw_gabriel_pedro.product_data.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Bill {

    @Id
    private String id;

    private Double total;

    private LocalDateTime date;

    private Double totalIva;

    @DBRef
    private List<Product> products;

    public Bill(Double total, Double totalIva, List<Product> products) {
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

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", total=" + total + '\'' +
                ", date=" + date + '\'' +
                ", totalIva=" + totalIva + '\'' +
                ", products=" + products + '\'' +
                '}';
    }

}
