package com.canis.his.entity;

import javax.persistence.*;

@Entity
@Table
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicineId;
    @Column
    private String medicineEncoding;
    @Column
    private String medicineName;
    @Column
    private String unit;
    @Column
    private String packageUnit;
    @Column
    private int jixingId;
    @Column
    private int medicineTypeId;
    @Column
    private float price;
    @Column
    private String medicinePinyin;

    public Medicine(){}

    public Medicine(String medicineEncoding, String medicineName, String unit, String packageUnit, int jixingId, int medicineTypeId, float price, String medicinePinyin) {
        this.medicineEncoding = medicineEncoding;
        this.medicineName = medicineName;
        this.unit = unit;
        this.packageUnit = packageUnit;
        this.jixingId = jixingId;
        this.medicineTypeId = medicineTypeId;
        this.price = price;
        this.medicinePinyin = medicinePinyin;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineEncoding() {
        return medicineEncoding;
    }

    public void setMedicineEncoding(String medicineEncoding) {
        this.medicineEncoding = medicineEncoding;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    public int getJixingId() {
        return jixingId;
    }

    public void setJixingId(int jixingId) {
        this.jixingId = jixingId;
    }

    public int getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(int medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMedicinePinyin() {
        return medicinePinyin;
    }

    public void setMedicinePinyin(String medicinePinyin) {
        this.medicinePinyin = medicinePinyin;
    }
}
