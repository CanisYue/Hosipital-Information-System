package com.canis.his.entity;

import javax.persistence.*;

@Entity
@Table
public class Completemodeldetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int completeModelDetailId;
    @Column
    private int completeModelId;
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

    public Completemodeldetail(){}

    public Completemodeldetail(int completeModelId, int medicineId, String way, String total, String frequency, int number) {
        this.completeModelId = completeModelId;
        this.medicineId = medicineId;
        this.way = way;
        this.total = total;
        this.frequency = frequency;
        this.number = number;
    }

    public int getCompleteModelDetailId() {
        return completeModelDetailId;
    }

    public void setCompleteModelDetailId(int completeModelDetailId) {
        this.completeModelDetailId = completeModelDetailId;
    }

    public int getCompleteModelId() {
        return completeModelId;
    }

    public void setCompleteModelId(int completeModelId) {
        this.completeModelId = completeModelId;
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
}
