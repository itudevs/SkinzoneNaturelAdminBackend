package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Sale_Line")
public class Sale_Line {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int saleLineID;
    //FK
    @ManyToOne(fetch=FetchType.LAZY)
    private Sale sale;
    //FK

    @ManyToOne(fetch=FetchType.LAZY)
    private Service service;

    @Column(unique=false, nullable=false)
    private Float amount;

    public int getSaleLineID() {
        return saleLineID;
    }



    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
