package com.example.kapitalbanktestproject.service.dto;

import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.Date;

public class PaymentDTO implements Serializable {

    private Long id;

    @NotNull
    private Date time;

    @NotNull
    private Double amount;

    private String status;

    @NotNull
    private Long invoiceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
