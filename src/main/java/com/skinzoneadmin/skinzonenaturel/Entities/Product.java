package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductID;

    @ManyToOne(cascade = CascadeType.ALL)
    private Service Service;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product_Category ProductCategory;

    @Column(unique = false,nullable = false)
    private LocalDate DateReceived;

    @Column(unique = false,nullable = false)
    private int Quantity;

    @Column(unique = false,nullable = false)
    private Float ClinicalPrice;



    public int getProductID() {
        return ProductID;
    }



    public Float getClinicalPrice() {
        return ClinicalPrice;
    }

    public void setClinicalPrice(Float clinicalPrice) {
        ClinicalPrice = clinicalPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public LocalDate getDateReceived() {
        return DateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        DateReceived = dateReceived;
    }

    public Product_Category getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(Product_Category productCategory) {
        ProductCategory = productCategory;
    }

    public Service getService() {
        return Service;
    }

    public void setService(Service service) {
        Service = service;
    }
}
