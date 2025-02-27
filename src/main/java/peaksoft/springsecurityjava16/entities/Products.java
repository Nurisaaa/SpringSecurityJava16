package peaksoft.springsecurityjava16.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_gen")
    @SequenceGenerator(name = "products_gen", sequenceName = "products_seq")
    private Long id;
    private String name;
    private String title;
    private String description;
    private LocalDate expiredDate;
    private LocalDate productionDate;
    private double price;
    private int count;

    public Products(Long id, String name, String title, String description, LocalDate expiredDate, LocalDate productionDate, double price) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.expiredDate = expiredDate;
        this.productionDate = productionDate;
        this.price = price;
    }

    public Products() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
