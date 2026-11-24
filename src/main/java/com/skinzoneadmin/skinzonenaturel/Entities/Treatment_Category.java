package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Treatment_Category")
public class Treatment_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TreatmentCategoryID;

    @Column(unique = true,nullable = false)
    private String TreatmentCategoryName;

    public int getTreatmentCategoryID() {
        return TreatmentCategoryID;
    }


    public String getTreatmentCategoryName() {
        return TreatmentCategoryName;
    }

    public void setTreatmentCategoryName(String treatmentCategoryName) {
        TreatmentCategoryName = treatmentCategoryName;
    }
}
