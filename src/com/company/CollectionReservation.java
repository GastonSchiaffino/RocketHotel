package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CollectionReservation implements FileRocketHotel{
    ///Atributos
    List<Reservation> listReservation = new ArrayList<>();

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


    public List<Room> searchRoomsForReservation(List<Room> rooms, LocalDate ci, LocalDate co) {
        List<Room> suitables = new ArrayList<>();
        boolean save;

        for (Room r : rooms) {
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
        return suitables;
    }

    @Override
    public void read(File file)  throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if(file.length()>0)
            listReservation = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Reservation.class));
    }

    @Override
    public void write(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, listReservation);
    }
}
