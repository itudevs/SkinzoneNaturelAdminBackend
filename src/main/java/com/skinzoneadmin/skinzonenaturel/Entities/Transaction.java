package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Column(unique = false,nullable = false)
    private Date transactionDate;

    @Column(unique = false,nullable = false)
    private LocalTime transactionTime;
    //only fetches the entity when code explicitly calls it
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = false, nullable = false)
    private User user;

    public int getTransactionId() {
        return transactionId;
    }


    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
