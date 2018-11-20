/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.targa.labs.myboutique.web.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 *
 * @author n.lamouchi
 */
public class OrderDto {
    private Long id;
    private BigDecimal totalPrice;
    private String status;
    private ZonedDateTime shipped;
    private PaymentDto payment;
    private AddressDto shipmentAddress;
    private Set<OrderItemDto> orderItems;

    public OrderDto() {
        // JACKSON
    }

    public OrderDto(Long id, BigDecimal totalPrice, String status,
                    ZonedDateTime shipped, PaymentDto payment,
                    AddressDto shipmentAddress, Set<OrderItemDto> orderItems) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.status = status;
        this.shipped = shipped;
        this.payment = payment;
        this.shipmentAddress = shipmentAddress;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ZonedDateTime getShipped() {
        return shipped;
    }

    public void setShipped(ZonedDateTime shipped) {
        this.shipped = shipped;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }

    public AddressDto getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(AddressDto shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public Set<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
