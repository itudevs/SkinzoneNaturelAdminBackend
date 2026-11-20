package com.skinzoneadmin.skinzonenaturel.Entities;

import com.skinzoneadmin.skinzonenaturel.structures.ServiceType;
import jakarta.persistence.*;

@Entity
@Table(name="Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ServiceID;

    @Column(unique=false, nullable=false)
    private String Name;
    @Column(unique=false, nullable=false)
    private Double Discount;

    @Column(unique=false, nullable=false)
    private Double RetailPrice;

    @Column(unique=false, nullable=false)
    private ServiceType Type;

    public int getServiceID() {
        return ServiceID;
    }



    public ServiceType getType() {
        return Type;
    }

    public void setType(ServiceType type) {
        Type = type;
    }

    public Double getRetailPrice() {
        return RetailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        RetailPrice = retailPrice;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
