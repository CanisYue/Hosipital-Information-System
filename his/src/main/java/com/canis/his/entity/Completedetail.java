package com.canis.his.entity;

import javax.persistence.*;

@Entity
@Table
public class Completedetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int completeDetailId;
    @Column
    private int completeId;
    @Column
    private int medicineId;
    @Column
    private String way;
    @Column
    private String total;
    @Column
    private String frequency;
    @Column
    private int number;
    @Column(name = "`status`")
    private int status;

    public Completedetail(){}

    public Completedetail(int completeId, int medicineId, String way, String total, String frequency, int number, int status) {
        this.completeId = completeId;
        this.medicineId = medicineId;
        this.way = way;
        this.total = total;
        this.frequency = frequency;
        this.number = number;
        this.status = status;
    }

    public int getCompleteDetailId() {
        return completeDetailId;
    }

    public void setCompleteDetailId(int completeDetailId) {
        this.completeDetailId = completeDetailId;
    }

    public int getCompleteId() {
        return completeId;
    }

    public void setCompleteId(int completeId) {
        this.completeId = completeId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
