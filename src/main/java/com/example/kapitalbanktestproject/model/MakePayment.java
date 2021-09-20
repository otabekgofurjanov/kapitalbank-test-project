package com.example.kapitalbanktestproject.model;

import java.util.Date;

public class MakePayment {
    private String status;

    private Long amount;

    private Date timestamp;

    private Long invoiceId;

    public MakePayment(Long amount, Date timestamp, Long invoiceId) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.invoiceId = invoiceId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }


    public MakePayment() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
