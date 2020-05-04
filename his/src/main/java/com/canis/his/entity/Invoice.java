package com.canis.his.entity;


import javax.persistence.*;

@Entity
@Table
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceNumber;
    @Column
    private float invoiceFund;
    @Column
    private int normalAbandon;
    @Column
    private String time;
    @Column
    private int operatorId;
    @Column
    private int registrationId;
    @Column
    private int paymentTypeId;
    @Column
    private int chonghong;
    @Column
    private int isDailyCheck;

    public Invoice(float invoiceFund, int normalAbandon, String time, int operatorId, int registrationId, int paymentTypeId, int chonghong, int isDailyCheck) {
        this.invoiceFund = invoiceFund;
        this.normalAbandon = normalAbandon;
        this.time = time;
        this.operatorId = operatorId;
        this.registrationId = registrationId;
        this.paymentTypeId = paymentTypeId;
        this.chonghong = chonghong;
        this.isDailyCheck = isDailyCheck;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public float getInvoiceFund() {
        return invoiceFund;
    }

    public void setInvoiceFund(float invoiceFund) {
        this.invoiceFund = invoiceFund;
    }

    public int getNormalAbandon() {
        return normalAbandon;
    }

    public void setNormalAbandon(int normalAbandon) {
        this.normalAbandon = normalAbandon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public int getChonghong() {
        return chonghong;
    }

    public void setChonghong(int chonghong) {
        this.chonghong = chonghong;
    }

    public int getIsDailyCheck() {
        return isDailyCheck;
    }

    public void setIsDailyCheck(int isDailyCheck) {
        this.isDailyCheck = isDailyCheck;
    }
}
