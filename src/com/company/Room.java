package com.company;

public class Room {

    //Atributos
    private int idRoom;
    private StatusRoom available;
    private int capacity;
    private double priceForDay;
    private String description;

    //Constructor
    public Room(){
    }

    public Room(int idRoom, StatusRoom available, int capacity, double priceForDay, String description) {
        this.idRoom = idRoom;
        this.available = available;
        this.capacity = capacity;
        this.priceForDay = priceForDay;
        this.description = description;
    }

    //Getters and Setters
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public StatusRoom getAvailable() {
        return available;
    }

    public void setAvailable(StatusRoom available) {
        this.available = available;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(double priceForDay) {
        this.priceForDay = priceForDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    ///Metodos
}
