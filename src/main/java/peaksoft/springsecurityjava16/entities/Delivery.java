package peaksoft.springsecurityjava16.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_gen")
    @SequenceGenerator(name = "delivery_gen", sequenceName = "delivery_seq")
    private Long id;
    private String email;
    private String company_name;
    @OneToOne
    private Order order;
    private double total_price;
    private String address;

    public Delivery() {
    }

    public Delivery(Long id, String email, Order order, String company_name, double total_price, String address) {
        this.id = id;
        this.email = email;
        this.order = order;
        this.company_name = company_name;
        this.total_price = total_price;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
