package com.skinzoneadmin.skinzonenaturel.Entities;

import com.skinzoneadmin.skinzonenaturel.structures.PAYMENTMETHODS;
import com.skinzoneadmin.skinzonenaturel.structures.VisitType;
import jakarta.persistence.*;

@Entity
@Table(name="Sale")
public class Sale {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int SaleID;

    @Column(unique=false, nullable=false)
    private PAYMENTMETHODS PaymentMethod;
    //might need to remove not needed
    @Column(unique = false,nullable = false)
    private VisitType  VisitType;
    @Column(unique = false, nullable=false)
    private Double SaleTotal;
    @ManyToOne
    private Transaction Transaction;
    @ManyToOne
    @JoinColumn(name = "Client_ClientID")
    private Client client;



    public int getSaleID() {
        return SaleID;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Transaction getTransaction() {
        return Transaction;
    }

    public void setTransaction(Transaction transaction) {
        Transaction = transaction;
    }

    public Double getSaleTotal() {
        return SaleTotal;
    }

    public void setSaleTotal(Double saleTotal) {
        SaleTotal = saleTotal;
    }

    public VisitType getVisitType() {
        return VisitType;
    }

    public void setVisitType(VisitType visitType) {
        VisitType = visitType;
    }

    public PAYMENTMETHODS getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(PAYMENTMETHODS paymentMethod) {
        PaymentMethod = paymentMethod;
    }
}
