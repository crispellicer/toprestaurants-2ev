package com.svalero.toprestaurants.domain;

import java.io.Serializable;

public class Customer implements Serializable {
    private long id;
    private String name;
    private String surname;
    private String telephone;
    private String birthDate;
    private boolean vip;

    public Customer(long id, String name, String surname, String telephone, String birthDate, boolean vip) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.vip = vip;
    }

    public Customer(String name, String surname, String telephone, String birthDate, boolean vip) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.vip = vip;
    }

    public Customer() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
