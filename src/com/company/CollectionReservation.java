package com.company;

import java.util.ArrayList;
import java.util.List;

public class CollectionReservation {
    ///Atributos
    private List<Reservation> listReservation= new ArrayList<>();

    ///Constructores
    public CollectionReservation(){
    }

    public CollectionReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    ///Getter and Setter

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    ///Metodos
    public Reservation searchReservation(String dni, CollectionReservation reservations){
        Reservation reservation = new Reservation();
        for (Reservation x: reservations.getListReservation()) {
            if (x.getDni().equals(dni)){
                reservation= x;
            }
        }
        return reservation;
    }

    public Reservation searchReservation(Object o, CollectionReservation reservations){
        Reservation reservation = new Reservation();

        for (Reservation x: reservations.getListReservation()) {
            if (o instanceof String) {
                if (x.getDni().equals(o)) {
                    reservation = x;
                }
            }else if(o instanceof Integer){
                if(x.getReservationNumber() == (int)o){
                    reservation = x;
                }
            }
        }
        return reservation;
    }

   /* public Reservation makeReservation(int idRoom){

    }*/
}
