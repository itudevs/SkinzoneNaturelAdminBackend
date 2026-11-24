package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Product_Category")
public class Product_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productCategory_ID;

    @Column(unique = true,nullable = false)
    private String productCategoryName;

    public int getProductCategory_ID() {
        return productCategory_ID;
    }

    public void setProductCategory_ID(int productCategory_ID) {
        this.productCategory_ID = productCategory_ID;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }
}
