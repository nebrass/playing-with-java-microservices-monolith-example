package com.targa.labs.myboutique.domain;

import com.targa.labs.myboutique.domain.enumeration.CartStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A Cart.
 */
@Entity
@Table(name = "cart")
public class Cart extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumn(unique = true)
    private Order order;

    @ManyToOne
    private Customer customer;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CartStatus status;

    public Cart(Customer customer) {
        this.customer = customer;
        this.status = CartStatus.NEW;
    }

    public Cart() {
        // JPA
    }

    public Cart(Order order, Customer customer, @NotNull CartStatus status) {
        this.order = order;
        this.customer = customer;
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(order, cart.order) &&
                Objects.equals(customer, cart.customer) &&
                status == cart.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, status);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "order=" + order.getId() +
                ", customer=" + customer +
                ", status=" + status +
                '}';
    }
}
