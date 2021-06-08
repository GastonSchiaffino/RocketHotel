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
    public Reservation searchReservation(int numberReservation) {
        Reservation reservation = null;

        for (Reservation x : listReservation) {
            if (x.getReservationNumber() == numberReservation) {
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
                if (x.isReserved()) {
                    reservations.add(x);
                }
            }
        }
        return reservations;
    }

    public boolean cancelledReservartion(int numberReservation) {

        Reservation reservation = searchReservation(numberReservation);

        if (reservation.isReserved()) {
            reservation.setReserved(false);
        }
        return reservation.isReserved();
    }


    public List<Room> searchRoomsForReservation(CollectionRoom rooms, LocalDate ci, LocalDate co) {
        List<Room> suitables = new ArrayList<>();
        boolean save;

        for (Room r : rooms.getListRoom()) {
            save=false;
            for (Reservation x : listReservation) {
                if (x.isReserved() && r.getIdRoom() == x.getIdRoom()) {
                    if (x.getCheckIn().isBefore(ci) && x.getCheckOut().isAfter(co)) {
                        save=true;
                    } else if (ci.isBefore(x.getCheckIn()) && co.isAfter(x.getCheckOut())) {
                        save=true;
                    } else if (co.isBefore(x.getCheckOut()) && co.isAfter(x.getCheckIn())) {
                        save=true;
                    } else if (ci.isAfter(x.getCheckIn()) && ci.isBefore(x.getCheckOut())) {
                        save=true;
                    }
                }
            }
            if(!save){
                suitables.add(r);
            }
        }
        return suitables;
    }
}
