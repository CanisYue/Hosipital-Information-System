package com.canis.his.entity;

import javax.persistence.*;

@Entity
@Table
public class Completemodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int completeModelId;
    @Column
    private String completeModelName;
    @Column
    private int doctorId;
    @Column
    private int suitableArea;

    public Completemodel() {
    }

    public Completemodel(String completeModelName, int doctorId, int suitableId) {
        this.completeModelName = completeModelName;
        this.doctorId = doctorId;
        this.suitableArea = suitableId;
    }

    public int getCompleteModelId() {
        return completeModelId;
    }

    public void setCompleteModelId(int completeModelId) {
        this.completeModelId = completeModelId;
    }

    public String getCompleteModelName() {
        return completeModelName;
    }

    public void setCompleteModelName(String completeModelName) {
        this.completeModelName = completeModelName;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getsuitableArea() {
        return suitableArea;
    }

    public void setsuitableArea(int suitableId) {
        this.suitableArea = suitableId;
    }
}
