package com.company;

public class Apartment {
    private String city;
    private int rooms;
    private int meters;
    private int price;
    private String phone;

    public Apartment(String city, int rooms, int meters, int price, String phone) {
        this.city = city;
        this.rooms = rooms;
        this.meters = meters;
        this.price = price;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
