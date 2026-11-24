package com.skinzoneadmin.skinzonenaturel.Entities;

import main.java.structures.ServiceType;
import jakarta.persistence.*;

@Entity
@Table(name="Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceID;

    @Column(unique=false, nullable=false)
    private String name;
    @Column(unique=false, nullable=false)
    private Float discount;

    @Column(unique=false, nullable=false)
    private Float retailPrice;

    @Column(unique=false, nullable=false)
    private ServiceType type;
    @Column(unique=false, nullable=false)
    private boolean active=true;

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Float retailPrice) {
        this.retailPrice = retailPrice;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
