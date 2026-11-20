package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int UserId;

    @Column(unique = true,nullable = false)
    private String Firebase_uid;
    @Column(unique=true,nullable=false)
    private String Email;
    @Column(unique=false,nullable=false)
    private String Name;
    @Column(unique=false,nullable=false)
    private String Surname;
    @Column(unique=false,nullable=false,length = 10)
    private String ContactNumber;
    @Column(unique=false,nullable=false)
    private boolean Active;

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getUserId() {
        return UserId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }
}
