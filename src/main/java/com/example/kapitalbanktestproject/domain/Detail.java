package com.example.kapitalbanktestproject.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detail")
public class Detail implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detail_id")
    @SequenceGenerator(name = "seq_detail_id", sequenceName = "seq_detail_id", allocationSize = 1, initialValue = 1)
    private Long id;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
