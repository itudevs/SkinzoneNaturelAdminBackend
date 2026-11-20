package main.java.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Expense")
public class Expense {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ExpenseID;

    @Column(unique = false,nullable = false)
    private String Name;

    @Column(unique = false,nullable = false)
    private int Quantity;
    @Column(unique = false,nullable = false)
    private Float PricePerItem;

    //category as per requirement is not needed
    //total price can be calculated on need
    @ManyToOne(cascade = CascadeType.ALL)
    private Transaction Transaction;

    public int getExpenseID() {
        return ExpenseID;
    }



    public Transaction getTransaction() {
        return Transaction;
    }

    public void setTransaction(Transaction transaction) {
        Transaction = transaction;
    }

    public Float getPricePerItem() {
        return PricePerItem;
    }

    public void setPricePerItem(Float pricePerItem) {
        PricePerItem = pricePerItem;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
