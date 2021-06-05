package com.company;

import java.util.List;

public class Client extends User implements ReservationStatus,Discount {
    ///Atributos
    boolean vip;
    List<Reservation> reservations;

    //Constructores
    public Client(){
        super();
    }

    public Client(String name, String surname, String dni, String gender, String origin, String address, String userName, String password, String emailAddress, boolean vip,List<Reservation> reservations) {
        super(name, surname, dni, gender, origin, address, userName, password, emailAddress);
        this.vip = vip;
        this.reservations=reservations;
    }

    //Getter and Setter
    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    //Metodos
    public String toString(){
        return super.toString() + "VIP: " + this.vip;
    }


}
