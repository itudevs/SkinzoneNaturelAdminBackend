package com.skinzoneadmin.skinzonenaturel.Entities;

import main.java.structures.PAYMENTMETHODS;
import main.java.structures.VisitType;
import jakarta.persistence.*;

@Entity
@Table(name="Sale")
public class Sale {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int saleID;

    //might need to remove not needed
    @Column(unique = false,nullable = false)
    private VisitType  visitType;
    @Column(unique = false, nullable=false)
    private Float saleTotal;
    @ManyToOne
    private Transaction transaction;
    @ManyToOne
    @JoinColumn(name = "Client_ClientID")
    private Client client;


    public int getSaleID() {
        return saleID;
    }


    public VisitType getVisitType() {
        return visitType;
    }

    public void setVisitType(VisitType visitType) {
        this.visitType = visitType;
    }

    public Float getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Float saleTotal) {
        this.saleTotal = saleTotal;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
