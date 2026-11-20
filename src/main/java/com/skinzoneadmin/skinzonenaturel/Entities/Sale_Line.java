package com.skinzoneadmin.skinzonenaturel.Entities;

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
    @Column(unique=false, nullable=true)
    @ManyToOne(fetch=FetchType.LAZY)
    private Service Service;

    @Column(unique=false, nullable=false)
    private Double Amount;
}
