package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListReservation {
    ///Atributos
    private Collection<Reservation> collectionReservation= new ArrayList<>();

    ///Constructores
    public ListReservation(){
    }

    public ListReservation(Collection<Reservation> collectionReservation) {
        this.collectionReservation = collectionReservation;
    }

    ///Getter and Setter
    public Collection<Reservation> getCollectionReservation() {
        return collectionReservation;
    }

    public void setCollectionReservation(Collection<Reservation> collectionReservation) {
        this.collectionReservation = collectionReservation;
    }

    ///Metodos
}
