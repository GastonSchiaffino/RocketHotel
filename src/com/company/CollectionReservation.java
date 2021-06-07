package com.company;

import java.time.LocalDate;
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
    public Reservation searchReservation(int numberReservation){
        Reservation reservation = new Reservation();
        for (Reservation x: listReservation) {
            if (x.getReservationNumber() == numberReservation){
                reservation= x;
            }
        }
        return reservation;
    }

    public  List<Reservation> searchReservationHistory(String dni) {
        List<Reservation> reservations = new ArrayList<>();
        for (Reservation x : listReservation) {
            if (x.getDni().equals(dni)) {
                reservations.add(x);
            }
        }
        return reservations;
    }

    public  List<Reservation> searchReservationCurrent(String dni) {
        List<Reservation> reservations = new ArrayList<>();
        for (Reservation x : listReservation) {
            if (x.getDni().equals(dni)) {
                if (x.isReserved()) {
                    reservations.add(x);
                }
            }
        }
        return reservations;
    }

    public boolean cancelledReservartion(int numberReservation){
        Reservation reservation=searchReservation(numberReservation);
        if(!reservation.isCancelled()){
            reservation.setCancelled(true);
        }
        return reservation.isCancelled();
    }

    /*public  boolean searchAvailable(LocalDate checkIn, int id) {

        for (Reservation x : listReservation) {
            if (x.isReserved()&& x.getIdRoom() == id) {
                if(x.getCheckIn())

            }
        }
        return reservations;
    }*/
}
