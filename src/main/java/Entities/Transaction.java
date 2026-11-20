package main.java.Entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TransactionId;

    @Column(unique = false,nullable = false)
    private Date TransactionDate;

    @Column(unique = false,nullable = false)
    private LocalTime TransactionTime;
    //only fetches the entity when code explicitly calls it
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = false, nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalTime getTransactionTime() {
        return TransactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        TransactionTime = transactionTime;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public int getTransactionId() {
        return TransactionId;
    }

}
