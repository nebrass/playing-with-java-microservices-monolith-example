package com.targa.labs.myboutique.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A OrderItem.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem extends AbstractEntity {

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    public OrderItem(@NotNull Long quantity, Product product, Order order) {
        this.quantity = quantity;
        this.product = product;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(quantity, orderItem.quantity) &&
                Objects.equals(product, orderItem.product) &&
                Objects.equals(order, orderItem.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, product, order);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "quantity=" + quantity +
                ", product=" + product.getName() +
                '}';
    }
}
