package com.canis.his.VO;

public class ResultEstimate {
    private String icd;
    private String time;
    private String name;

    public ResultEstimate(String icd, String time, String name) {
        this.icd = icd;
        this.time = time;
        this.name = name;
    }

    public String getIcd() {
        return icd;
    }

    public void setIcd(String icd) {
        this.icd = icd;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
