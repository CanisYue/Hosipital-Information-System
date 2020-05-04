package com.canis.his.VO;

public class RegistrationReturn {
    private int paper_id;
    private int invoice_id;
    private float fund;
    private String book_id;

    public RegistrationReturn(int paper_id, int invoice_id, float fund, String book_id) {
        this.paper_id = paper_id;
        this.invoice_id = invoice_id;
        this.fund = fund;
        this.book_id = book_id;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public float getFund() {
        return fund;
    }

    public void setFund(float fund) {
        this.fund = fund;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
}
