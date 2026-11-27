package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    @ManyToOne(cascade = CascadeType.ALL)
    private Service service;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product_Category productCategory;

    @Column(unique = false,nullable = false)
    private LocalDate dateReceived;

    @Column(unique = false,nullable = false)
    private int quantity;

    @Column(unique = false,nullable = false)
    private Float clinicalPrice;


    public int getProductID() {
        return productID;
    }



    public Float getClinicalPrice() {
        return clinicalPrice;
    }

    public void setClinicalPrice(Float clinicalPrice) {
        this.clinicalPrice = clinicalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product_Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Product_Category productCategory) {
        this.productCategory = productCategory;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
