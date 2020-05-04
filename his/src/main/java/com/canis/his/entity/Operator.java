package com.canis.his.entity;

import javax.persistence.*;

@Entity
@Table(name = "operator")
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int operator_id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "realname")
    private String realname;
    @Column(name = "operator_type_id")
    private int operator_type_id;
    @Column(name = "department_id")
    private int department_id;
    @Column(name = "`delete`")
    private int delete;

    public Operator(String username, String password, String realname, int operator_type_id, int department_id) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.operator_type_id = operator_type_id;
        this.department_id = department_id;
        this.delete = 1;
    }

    protected Operator() {
    }


    public int getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
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

    public int getOperator_type_id() {
        return operator_type_id;
    }

    public void setOperator_type_id(int operator_type_id) {
        this.operator_type_id = operator_type_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}

