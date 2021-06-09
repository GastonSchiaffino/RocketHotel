package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CollectionReservation {
    ///Atributos
    private List<Reservation> listReservation = new ArrayList<>();

    ///Constructores
    public CollectionReservation() {
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
    public void addReservation(Reservation reservation){
        listReservation.add(reservation);
    }

    public Reservation searchReservation(int numberReservation) {
        Reservation reservation = null;

        for (Reservation x : listReservation) {
            if (x.getReservationNumber() == numberReservation) {
                reservation = x;
            }
        }
        return reservation;
    }

    public Reservation searchReservationAsDni(String dni) {
        Reservation reservation = null;

        for (Reservation x : listReservation) {
            if (x.getDni().equals(dni)) {
                reservation = x;
            }
        }
        return reservation;
    }

    public List<Reservation> searchReservationHistory(String dni) {
        List<Reservation> reservations = new ArrayList<>();
        for (Reservation x : listReservation) {
            if (x.getDni().equals(dni)) {
                reservations.add(x);
            }
        }
        return reservations;
    }

    public List<Reservation> searchReservationCurrent(String dni) {
        List<Reservation> reservations = new ArrayList<>();
        for (Reservation x : listReservation) {
            if (x.getDni().equals(dni)) {
                if (!x.isCancelled()) {
                    reservations.add(x);
                }
            }
        }
        return reservations;
    }


    public void showListReservationCurrent() {
        for (Reservation x : listReservation) {
            if (!x.isCancelled()) {
                System.out.println(x.toString());
            }
        }
    }

    public void cancelledReservartion(int numberReservation) {

        Reservation reservation = searchReservation(numberReservation);

        if (!reservation.isCancelled()) {
            reservation.setCancelled(true);
        }
    }


    public List<Room> searchRoomsForReservation(CollectionRoom rooms, LocalDate ci, LocalDate co, int capacity) {
        List<Room> suitables = new ArrayList<>();
        boolean save;

        for (Room r : rooms.getListRoom()) {
            if (capacity == r.getCapacity()) {
                save = false;
                for (Reservation x : listReservation) {
                    if (!x.isCancelled() && r.getIdRoom() == x.getIdRoom()) {
                        if (x.getCheckIn().isBefore(ci) && x.getCheckOut().isAfter(co) ||
                                ci.isBefore(x.getCheckIn()) && co.isAfter(x.getCheckOut()) ||
                                co.isBefore(x.getCheckOut()) && co.isAfter(x.getCheckIn()) ||
                                ci.isAfter(x.getCheckIn()) && ci.isBefore(x.getCheckOut())) {
                            save = true;
                        }
                    }
                    if (!save) {
                        suitables.add(r);
                    }
                }
            }
        }
        return suitables;
    }
}
