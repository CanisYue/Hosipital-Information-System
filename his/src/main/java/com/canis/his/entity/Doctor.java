package com.canis.his.entity;

import javax.persistence.*;

@Entity
@Table
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctor_id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String realname;
    @Column
    private int doctor_type;
    @Column
    private int tittle_id;
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "registration_level_id")
    private int registrationLevelId;

    public Doctor(){}

    public Doctor(String username, String password, String realname, int doctor_type, int tittle_id, int department_id, int registration_level_id) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.doctor_type = doctor_type;
        this.tittle_id = tittle_id;
        this.departmentId = department_id;
        this.registrationLevelId = registration_level_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getDoctor_type() {
        return doctor_type;
    }

    public void setDoctor_type(int doctor_type) {
        this.doctor_type = doctor_type;
    }

    public int getTittle_id() {
        return tittle_id;
    }

    public void setTittle_id(int tittle_id) {
        this.tittle_id = tittle_id;
    }

    public int getDepartment_id() {
        return departmentId;
    }

    public void setDepartment_id(int department_id) {
        this.departmentId = department_id;
    }

    public int getRegistration_level_id() {
        return registrationLevelId;
    }

    public void setRegistration_level_id(int registration_level_id) {
        this.registrationLevelId = registration_level_id;
    }
}
