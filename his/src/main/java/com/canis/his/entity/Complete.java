package com.canis.his.entity;

import javax.persistence.*;

@Entity
@Table
public class Complete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int completeId;
    @Column
    private int registrationBookId;
    @Column
    private int registrationPaperId;
    @Column
    private int doctorId;
    @Column
    private String completeName;
    @Column
    private String createdTime;
    @Column(name = "`status`")
    private int status;

    public Complete(){}

    public Complete(int registrationBookId, int registrationPaperId, int doctorId, String completeName, String createdTime, int status) {
        this.registrationBookId = registrationBookId;
        this.registrationPaperId = registrationPaperId;
        this.doctorId = doctorId;
        this.completeName = completeName;
        this.createdTime = createdTime;
        this.status = status;
    }



    public int getCompleteId() {
        return completeId;
    }

    public void setCompleteId(int completeId) {
        this.completeId = completeId;
    }

    public int getRegistrationBookId() {
        return registrationBookId;
    }

    public void setRegistrationBookId(int registrationBookId) {
        this.registrationBookId = registrationBookId;
    }

    public int getRegistrationPaperId() {
        return registrationPaperId;
    }

    public void setRegistrationPaperId(int registrationPaperId) {
        this.registrationPaperId = registrationPaperId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
