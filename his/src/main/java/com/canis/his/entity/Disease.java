package com.canis.his.entity;

import javax.persistence.*;

@Entity
@Table
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diseaseId;
    @Column
    private String diseasePinyin;
    @Column
    private String diseaseName;
    @Column
    private String diseaseIcd;
    @Column
    private int diseaseTypeId;

    public Disease(){}

    public Disease(String diseasePinyin, String diseaseName, String diseaseIcd, int diseaseTypeId) {
        this.diseasePinyin = diseasePinyin;
        this.diseaseName = diseaseName;
        this.diseaseIcd = diseaseIcd;
        this.diseaseTypeId = diseaseTypeId;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseasePinyin() {
        return diseasePinyin;
    }

    public void setDiseasePinyin(String diseasePinyin) {
        this.diseasePinyin = diseasePinyin;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseIcd() {
        return diseaseIcd;
    }

    public void setDiseaseIcd(String diseaseIcd) {
        this.diseaseIcd = diseaseIcd;
    }

    public int getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(int diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }
}
