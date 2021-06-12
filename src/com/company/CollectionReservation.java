package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    public List<Room> searchRoomsForReservation(List<Room> rooms, String ci, String co) {
        List<Room> suitables = new ArrayList<>();
        boolean save;



        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate localDateCI;
        LocalDate localDateCO;
        try {
            localDateCI = LocalDate.parse(ci, dateTimeFormatter);
            localDateCO =  LocalDate.parse(co, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            return null;
        }

        for (Room r : rooms) {
                save = false;
                if(!listReservation.isEmpty()) {
                    for (Reservation x : listReservation) {
                        if (!x.isCancelled() && r.getIdRoom() == x.getIdRoom()) {
                            if (Objects.requireNonNull(Reservation.stringToLocalDate(x.getCheckIn())).isBefore(localDateCI) && Objects.requireNonNull(Reservation.stringToLocalDate(x.getCheckOut())).isAfter(localDateCO) ||
                                    localDateCI.isBefore(Objects.requireNonNull(Reservation.stringToLocalDate(x.getCheckIn()))) && localDateCO.isAfter(Objects.requireNonNull(Reservation.stringToLocalDate(x.getCheckOut()))) ||
                                    localDateCO.isBefore(Objects.requireNonNull(Reservation.stringToLocalDate(x.getCheckOut()))) && localDateCO.isAfter(Objects.requireNonNull(Reservation.stringToLocalDate(x.getCheckIn()))) ||
                                    localDateCI.isAfter(Objects.requireNonNull(Reservation.stringToLocalDate(x.getCheckIn()))) && localDateCI.isBefore(Objects.requireNonNull(Reservation.stringToLocalDate(x.getCheckOut())))) {
                                save = true;
                            }
                        }
                        if (!save) {
                            suitables.add(r);
                        }
                    }
                }
                else {
                    suitables.add(r);
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
