package com.example.kapitalbanktestproject.service.dto;

import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.Date;

public class InvoiceDTO implements Serializable {

    private Long id;

    @NotNull
    private Double amount;

    @NotNull
    private Date issued;

    @NotNull
    private Date due;

    @NotNull
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

}
