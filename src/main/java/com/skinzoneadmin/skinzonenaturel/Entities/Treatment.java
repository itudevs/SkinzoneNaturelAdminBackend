package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TreatmentID;

    @ManyToOne(cascade = CascadeType.ALL)
    private Treatment_Category TreatmentCategory;

    public Treatment_Category getTreatmentCategory() {
        return TreatmentCategory;
    }

    public void setTreatmentCategory(Treatment_Category treatmentCategory) {
        TreatmentCategory = treatmentCategory;
    }

    @OneToOne
    private Service service;

    public int getTreatmentID() {
        return TreatmentID;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
