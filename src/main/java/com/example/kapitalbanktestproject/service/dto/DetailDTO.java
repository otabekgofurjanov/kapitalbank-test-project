package com.example.kapitalbanktestproject.service.dto;

import com.sun.istack.NotNull;

import java.io.Serializable;

public class DetailDTO implements Serializable {

    private Long id;

    private int quantity;

    @NotNull
    private Long orderId;

    @NotNull
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
