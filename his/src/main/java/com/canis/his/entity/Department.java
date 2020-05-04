package com.canis.his.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;
    @Column
    private String department_encoding;
    @Column
    private String department_name;
    @Column
    private String department_type_id;
    @Column
    private String department_category_id;

    public Department(){}

    public Department(String department_encoding, String department_name, String department_type_id, String department_category_id) {
        this.department_encoding = department_encoding;
        this.department_name = department_name;
        this.department_type_id = department_type_id;
        this.department_category_id = department_category_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_encoding() {
        return department_encoding;
    }

    public void setDepartment_encoding(String department_encoding) {
        this.department_encoding = department_encoding;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_type_id() {
        return department_type_id;
    }

    public void setDepartment_type_id(String department_type_id) {
        this.department_type_id = department_type_id;
    }

    public String getDepartment_category_id() {
        return department_category_id;
    }

    public void setDepartment_category_id(String department_category_id) {
        this.department_category_id = department_category_id;
    }
}
