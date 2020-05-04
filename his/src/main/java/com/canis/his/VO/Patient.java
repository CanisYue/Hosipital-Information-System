package com.canis.his.VO;

public class Patient {
    private int book_id;
    private int paper_id;
    private String name;

    public Patient(int book_id, int paper_id, String name) {
        this.book_id = book_id;
        this.paper_id = paper_id;
        this.name = name;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
