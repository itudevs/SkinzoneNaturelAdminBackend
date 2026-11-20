package main.java.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Sale_Line")
public class Sale_Line {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Sale_LineID;
    //FK
    @ManyToOne(fetch=FetchType.LAZY)
    private Sale Sale;
    //FK

    @ManyToOne(fetch=FetchType.LAZY)
    private Service Service;

    @Column(unique=false, nullable=false)
    private Float Amount;

    public int getSale_LineID() {
        return Sale_LineID;
    }


    public Sale getSale() {
        return Sale;
    }

    public void setSale(Sale sale) {
        Sale = sale;
    }

    public Service getService() {
        return Service;
    }

    public void setService(Service service) {
        Service = service;
    }

    public Float getAmount() {
        return Amount;
    }

    public void setAmount(Float amount) {
        Amount = amount;
    }
}
