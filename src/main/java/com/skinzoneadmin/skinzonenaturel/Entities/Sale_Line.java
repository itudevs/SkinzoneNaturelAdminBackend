package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Sale_Line")
public class Sale_Line {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Sale_LineID;

    @ManyToOne(fetch=FetchType.LAZY)
    private Sale Sale;

    @Column(unique=false, nullable=true)
    @ManyToOne(fetch=FetchType.LAZY)
    private Product Product;

    @Column(unique=false, nullable=false)
    private String Sale_Line_Description;
}
