/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.targa.labs.myboutique.web.dto;

/**
 * @author n.lamouchi
 */
public class CartDto {
    private Long id;
    private Long orderId;
    private CustomerDto customerDto;
    private String status;

    public CartDto() {
        // JACKSON
    }

    public CartDto(Long id, Long orderId, CustomerDto customerDto, String status) {
        this.id = id;
        this.orderId = orderId;
        this.customerDto = customerDto;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
