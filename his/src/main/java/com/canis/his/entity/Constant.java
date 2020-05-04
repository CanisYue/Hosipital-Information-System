package com.canis.his.entity;

import javax.persistence.*;

@Entity
@Table
public class Constant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int constant_id;
    @Column
    private int constant_category_id;
    @Column
    private String constant_encoding;
    @Column
    private String constant_name;

    public Constant(){}

    public Constant(int constant_category_id, String constant_encoding, String constant_name) {
        this.constant_category_id = constant_category_id;
        this.constant_encoding = constant_encoding;
        this.constant_name = constant_name;
    }

    public int getConstant_id() {
        return constant_id;
    }

    public void setConstant_id(int constant_id) {
        this.constant_id = constant_id;
    }

    public int getConstant_category_id() {
        return constant_category_id;
    }

    public void setConstant_category_id(int constant_category_id) {
        this.constant_category_id = constant_category_id;
    }

    public String getConstant_encoding() {
        return constant_encoding;
    }

    public void setConstant_encoding(String constant_encoding) {
        this.constant_encoding = constant_encoding;
    }

    public String getConstant_name() {
        return constant_name;
    }

    public void setConstant_name(String constant_name) {
        this.constant_name = constant_name;
    }
}
