package com.canis.his.VO;

public class FundInfo {
    private int book_id;
    private int paper_id;
    private String name;
    private String medicine_name;
    private int number;
    private float price;
    private String time;
    private String status;
    private String id_number;
    private int detail_id;

    public FundInfo(int book_id, int paper_id, String name, String medicine_name, int number, float price, String time, String status, String id_number) {
        this.book_id = book_id;
        this.paper_id = paper_id;
        this.name = name;
        this.medicine_name = medicine_name;
        this.number = number;
        this.price = price;
        this.time = time;
        this.status = status;
        this.id_number = id_number;
    }

    public FundInfo(int book_id, int paper_id, String name, String medicine_name, int number, float price, String time, String status, String id_number, int detail_id) {
        this.book_id = book_id;
        this.paper_id = paper_id;
        this.name = name;
        this.medicine_name = medicine_name;
        this.number = number;
        this.price = price;
        this.time = time;
        this.status = status;
        this.id_number = id_number;
        this.detail_id = detail_id;
    }

    public FundInfo(String name, String id_number){
        this.name = name;
        this.id_number = id_number;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
