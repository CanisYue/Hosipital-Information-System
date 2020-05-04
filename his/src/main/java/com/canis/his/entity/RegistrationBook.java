package com.canis.his.entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
@Table(name = "registrationbook")
public class RegistrationBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registration_book_number;
    @Column(name = "`name`")
    private String name;
    @Column(name = "registration_book_id_number")
    private String registration_book_id_number;
    @Column(name = "birth")
    private String birth;
    @Column(name = "gender")
    private int gender;

    public RegistrationBook(){}

    public RegistrationBook(String name, String registration_book_id_number, String birth, int gender) {
        this.name = name;
        this.registration_book_id_number = registration_book_id_number;
        this.birth = birth;
        this.gender = gender;
    }

    public int getRegistration_book_number() {
        return registration_book_number;
    }

    public void setRegistration_book_number(int registration_book_number) {
        this.registration_book_number = registration_book_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration_book_id_number() {
        return registration_book_id_number;
    }

    public void setRegistration_book_id_number(String registration_book_id_number) {
        this.registration_book_id_number = registration_book_id_number;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}

