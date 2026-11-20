package main.java.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Product_Category")
public class Product_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Product_Category_ID;

    @Column(unique = true,nullable = false)
    private String Product_Category_Name;

    public int getProduct_Category_ID() {
        return Product_Category_ID;
    }


    public String getProduct_Category_Name() {
        return Product_Category_Name;
    }

    public void setProduct_Category_Name(String product_Category_Name) {
        Product_Category_Name = product_Category_Name;
    }
}
