package com.targa.labs.myboutique.web.dto;

/**
 * @author Nebrass Lamouchi
 */
public class CartDto {
    private Long id;
    private Long orderId;
    private Long customerDto;
    private String status;

    public CartDto() {
        // JACKSON
    }

    public CartDto(Long id, Long orderId, Long customerDto, String status) {
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

    public Long getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(Long customerDto) {
        this.customerDto = customerDto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
