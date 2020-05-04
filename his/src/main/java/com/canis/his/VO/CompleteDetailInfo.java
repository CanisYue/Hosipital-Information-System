package com.canis.his.VO;

public class CompleteDetailInfo {
    private String name;
    private String unit;
    private float price;
    private String way;
    private String frequency;
    private String total;
    private int number;
    private int complete_detail_id;

    public CompleteDetailInfo(int complete_detail_id, String name, String unit, float price, String way, String frequency, String total, int number) {
        this.complete_detail_id = complete_detail_id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.way = way;
        this.frequency = frequency;
        this.total = total;
        this.number = number;
    }

    public CompleteDetailInfo(String name, String unit, float price, String way, String frequency, String total, int number) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.way = way;
        this.frequency = frequency;
        this.total = total;
        this.number = number;
    }

    public int getComplete_detail_id() {
        return complete_detail_id;
    }

    public void setComplete_detail_id(int complete_detail_id) {
        this.complete_detail_id = complete_detail_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

