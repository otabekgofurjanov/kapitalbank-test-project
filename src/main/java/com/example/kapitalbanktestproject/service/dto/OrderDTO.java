package com.example.kapitalbanktestproject.service.dto;

import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.Date;

public class OrderDTO implements Serializable {

    private Long id;

    @NotNull
    private Date date;

    @NotNull
    private Long customerId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
