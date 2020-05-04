package com.canis.his.entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
@Table
public class Registrationpaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationPaperId;
    @Column
    private int registrationBookId;
    @Column
    private String name;
    @Column
    private String idNumber;
    @Column
    private String birth;
    @Column
    private int age;
    @Column
    private String birthType;
    @Column
    private String address;
    @Column
    private String morningAfternoon;
    @Column
    private int departmentId;
    @Column
    private int doctorId;
    @Column
    private int registrationLevelId;
    @Column
    private int settlementTypeId;
    @Column
    private int requestBook;
    @Column
    private String registrationDatetime;
    @Column
    private int operatorId;
    @Column(name = "`status`")
    private int status;

    public Registrationpaper(){}


    public Registrationpaper(int registrationBookId, String name, String idNumber, String birth, int age, String birthType, String address, String morningAfternoon, int departmentId, int doctorId, int registrationLevelId, int settlementTypeId, int requestBook, String registrationDateTime, int operatorId, int status) {
        this.registrationBookId = registrationBookId;
        this.name = name;
        this.idNumber = idNumber;
        this.birth = birth;
        this.age = age;
        this.birthType = birthType;
        this.address = address;
        this.morningAfternoon = morningAfternoon;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.registrationLevelId = registrationLevelId;
        this.settlementTypeId = settlementTypeId;
        this.requestBook = requestBook;
        this.registrationDatetime = registrationDateTime;
        this.operatorId = operatorId;
        this.status = status;
    }

    public int getRegistrationPaperId() {
        return registrationPaperId;
    }

    public void setRegistrationPaperId(int registrationPaperId) {
        this.registrationPaperId = registrationPaperId;
    }

    public int getRegistrationBookId() {
        return registrationBookId;
    }

    public void setRegistrationBookId(int registrationBookId) {
        this.registrationBookId = registrationBookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthType() {
        return birthType;
    }

    public void setBirthType(String birthType) {
        this.birthType = birthType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMorningAfternoon() {
        return morningAfternoon;
    }

    public void setMorningAfternoon(String morningAfternoon) {
        this.morningAfternoon = morningAfternoon;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getRegistrationLevelId() {
        return registrationLevelId;
    }

    public void setRegistrationLevelId(int registrationLevelId) {
        this.registrationLevelId = registrationLevelId;
    }

    public int getSettlementTypeId() {
        return settlementTypeId;
    }

    public void setSettlementTypeId(int settlementTypeId) {
        this.settlementTypeId = settlementTypeId;
    }

    public int getRequestBook() {
        return requestBook;
    }

    public void setRequestBook(int requestBook) {
        this.requestBook = requestBook;
    }

    public String getRegistrationDateTime() {
        return registrationDatetime;
    }

    public void setRegistrationDateTime(String registrationDateTime) {
        this.registrationDatetime = registrationDateTime;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
