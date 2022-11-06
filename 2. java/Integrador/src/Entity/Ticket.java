package Entity;

import java.util.List;
import java.util.Objects;

public class Ticket {

    private Customer customer;
    private List<Product>products;
    private Double total;

    public Ticket(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(customer, ticket.customer) && Objects.equals(products, ticket.products) && Objects.equals(total, ticket.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, products, total);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "customer=" + customer +
                ", products=" + products +
                ", total=" + total +
                '}';
    }
}
