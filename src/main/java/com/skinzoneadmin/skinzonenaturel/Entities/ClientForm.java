package com.skinzoneadmin.skinzonenaturel.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name = "ClientForm")
public class ClientForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String todayTreatmentGoal;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(nullable = false,columnDefinition = "jsonb")
    private Map<String,Object> answers=new HashMap<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTodayTreatmentGoal() {
        return todayTreatmentGoal;
    }

    public void setTodayTreatmentGoal(String todayTreatmentGoal) {
        this.todayTreatmentGoal = todayTreatmentGoal;
    }

    public Map<String, Object> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Object> answers) {
        this.answers = answers;
    }
}
