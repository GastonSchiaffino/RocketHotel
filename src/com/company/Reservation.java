package com.company;

import java.time.LocalDate;

public class Reservation {
    ///Atributos
    private String dni;
    private int idRoom;
    private int reservationNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private boolean cancelled;
    private boolean reserved;

    ///Constructores

    public Reservation(){
    }

    public Reservation(String dni, int idRoom, int reservationNumber, LocalDate checkIn, LocalDate checkOut, boolean cancelled, boolean reserved) {
        this.dni = dni;
        this.idRoom = idRoom;
        this.reservationNumber = reservationNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cancelled = cancelled;
        this.reserved = reserved;
    }

    ///Getters and Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }



    ///Metodos

}
