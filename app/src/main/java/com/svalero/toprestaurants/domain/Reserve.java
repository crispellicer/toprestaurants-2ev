package com.svalero.toprestaurants.domain;


public class Reserve {

    private long id;
    private long customerId;
    private long restaurantId;
    private int people;
    private int tables;
    private String reserveDate;
    private boolean isPaid;
    private boolean allergic;

    public Reserve(long id, long customerId, long restaurantId, int people, int tables, String reserveDate, boolean isPaid, boolean allergic) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.people = people;
        this.tables = tables;
        this.reserveDate = reserveDate;
        this.isPaid = isPaid;
        this.allergic = allergic;
    }

    public Reserve(long customerId, long restaurantId, int people, int tables, String reserveDate, boolean isPaid, boolean allergic) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.people = people;
        this.tables = tables;
        this.reserveDate = reserveDate;
        this.isPaid = isPaid;
        this.allergic = allergic;
    }

    public Reserve(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isAllergic() {
        return allergic;
    }

    public void setAllergic(boolean allergic) {
        this.allergic = allergic;
    }
}
