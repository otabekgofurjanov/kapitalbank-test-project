package com.example.kapitalbanktestproject.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_id")
    @SequenceGenerator(name = "seq_product_id", sequenceName = "seq_product_id", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "description", length = 20)
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "photo", nullable = true, length = 1024)
    private String photo;

    @ManyToOne
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
