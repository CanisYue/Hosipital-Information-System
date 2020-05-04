package com.canis.his.VO;

public class Record {
    private String date;
    private String morning_afternoon;
    private String department;
    private String doctor;
    private String status;
    private int paper_id;
    private String id_number;
    private String name;

    public Record(String date, String morning_afternoon, String department, String doctor, String status, int paper_id, String id_number, String name) {
        this.date = date;
        this.morning_afternoon = morning_afternoon;
        this.department = department;
        this.doctor = doctor;
        this.status = status;
        this.paper_id = paper_id;
        this.id_number = id_number;
        this.name = name;
    }



    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMorning_afternoon() {
        return morning_afternoon;
    }

    public void setMorning_afternoon(String morning_afternoon) {
        this.morning_afternoon = morning_afternoon;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
