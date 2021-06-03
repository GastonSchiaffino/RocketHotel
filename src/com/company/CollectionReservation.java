package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionReservation {
    ///Atributos
    private List<Reservation> collectionReservation= new ArrayList<>();

    ///Constructores
    public CollectionReservation(){
    }

    public CollectionReservation(List<Reservation> collectionReservation) {
        this.collectionReservation = collectionReservation;
    }

    ///Getter and Setter
    public List<Reservation> getCollectionReservation() {
        return collectionReservation;
    }

    public void setCollectionReservation(List<Reservation> collectionReservation) {
        this.collectionReservation = collectionReservation;
    }

    ///Metodos
}
