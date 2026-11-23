package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userId;

    @Column(unique = true,nullable = false)
    private String firebaseUid;
    @Column(unique=true,nullable=false)
    private String email;



    @Column(unique=false,nullable=false)
    private String name;
    @Column(unique=false,nullable=false)
    private String surname;
    @Column(unique=false,nullable=false,length = 10)
    private String contactNumber;
    @Column(unique=false,nullable=false)
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebase_uid) {
        this.firebaseUid = firebase_uid;
    }

    public int getUserId() {
        return userId;
    }


}
