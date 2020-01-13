package com.targa.labs.myboutique.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.targa.labs.myboutique.domain.enumeration.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

/**
 * A Orders.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "shipped")
    private ZonedDateTime shipped;

    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;

    @Embedded
    private Address shipmentAddress;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderItem> orderItems;

    @OneToOne
    @JsonIgnore
    private Cart cart;

    public Order(@NotNull BigDecimal totalPrice, @NotNull OrderStatus status,
                 ZonedDateTime shipped, Payment payment, Address shipmentAddress,
                 Set<OrderItem> orderItems, Cart cart) {
        this.totalPrice = totalPrice;
        this.status = status;
        this.shipped = shipped;
        this.payment = payment;
        this.shipmentAddress = shipmentAddress;
        this.orderItems = orderItems;
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(totalPrice, order.totalPrice) &&
                status == order.status &&
                Objects.equals(shipped, order.shipped) &&
                Objects.equals(payment, order.payment) &&
                Objects.equals(shipmentAddress, order.shipmentAddress) &&
                Objects.equals(orderItems, order.orderItems) &&
                Objects.equals(cart, order.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPrice, status, shipped, payment, shipmentAddress, cart);
    }

    @Override
    public String toString() {
        return "Order{" +
                "totalPrice=" + totalPrice +
                ", status=" + status +
                ", shipped=" + shipped +
                ", payment=" + payment +
                ", shipmentAddress=" + shipmentAddress +
                ", cart=" + cart.getId() +
                '}';
    }
}
