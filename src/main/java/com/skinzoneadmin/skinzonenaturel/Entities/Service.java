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
    private Float Discount;

    @Column(unique=false, nullable=false)
    private Float RetailPrice;

    @Column(unique=false, nullable=false)
    private ServiceType Type;
    @Column(unique=false, nullable=false)
    private boolean Active=true;

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public int getServiceID() {
        return ServiceID;
    }



    public ServiceType getType() {
        return Type;
    }

    public void setType(ServiceType type) {
        Type = type;
    }

    public Float getRetailPrice() {
        return RetailPrice;
    }

    public void setRetailPrice(Float retailPrice) {
        RetailPrice = retailPrice;
    }

    public Float getDiscount() {
        return Discount;
    }

    public void setDiscount(Float discount) {
        Discount = discount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
