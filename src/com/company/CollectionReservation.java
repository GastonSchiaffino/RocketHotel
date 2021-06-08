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
        Reservation reservation= null;

        for (Reservation x: listReservation) {
            if (x.getReservationNumber() == numberReservation){
                reservation= x;
            }
        }
        return reservation;
    }

    public Reservation searchReservationAsDni(String dni){
        Reservation reservation= null;

        for (Reservation x: listReservation) {
            if (x.getDni().equals(dni)){
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

    public void showListReservationCurrent(){
        for (Reservation x:listReservation) {
            if(x.isReserved()){
                System.out.println(x.toString());
            }
        }
    }




}
