package com.canis.his.VO;

public class BasicInfo {
    private String name;
    private String id_number;

    public BasicInfo(String name, String id_number) {
        this.name = name;
        this.id_number = id_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }
}
