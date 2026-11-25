package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private int numberOfPeopleTreated;
    @ManyToOne(cascade = CascadeType.ALL)
    private Treatment_Category category;
    @OneToOne
    private Service service;

    public int getId() {
        return id;
    }

    public int getNumberOfPeopleTreated() {
        return numberOfPeopleTreated;
    }

    public void setNumberOfPeopleTreated(int numberOfPeopleTreated) {
        this.numberOfPeopleTreated = numberOfPeopleTreated;
    }

    public Treatment_Category getCategory() {
        return category;
    }

    public void setCategory(Treatment_Category category) {
        this.category = category;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
