package com.svalero.toprestaurants.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Restaurant implements Serializable {
    private long id;
    private String name;
    private String timetable;
    private String type;
    private double reservePrice;
    private boolean veganMenu;
    private String website;
    private double longitude;
    private double latitude;


    public Restaurant(long id, String name, String timetable, String type, double reservePrice, boolean veganMenu, String website, double longitude, double latitude) {
        this.id = id;
        this.name = name;
        this.timetable = timetable;
        this.type = type;
        this.reservePrice = reservePrice;
        this.veganMenu = veganMenu;
        this.website = website;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public Restaurant(long id, String name, String timetable, String type, double reservePrice, boolean veganMenu, String website) {
        this.id = id;
        this.name = name;
        this.timetable = timetable;
        this.type = type;
        this.reservePrice = reservePrice;
        this.veganMenu = veganMenu;
        this.website = website;
    }

    public Restaurant(String name, String timetable, String type, double reservePrice, boolean veganMenu, String website, double longitude, double latitude) {
        this.name = name;
        this.timetable = timetable;
        this.type = type;
        this.reservePrice = reservePrice;
        this.veganMenu = veganMenu;
        this.website = website;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public Restaurant(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(double reservePrice) {
        this.reservePrice = reservePrice;
    }

    public boolean isVeganMenu() {
        return veganMenu;
    }

    public void setVeganMenu(boolean veganMenu) {
        this.veganMenu = veganMenu;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

