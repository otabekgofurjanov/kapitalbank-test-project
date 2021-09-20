package com.example.kapitalbanktestproject.result;

public class MakeOrderResult {

    private String status;

    private Long invoiceNum;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(Long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }
}
