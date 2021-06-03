package com.company;

import java.util.ArrayList;
import java.util.List;

public class CollectionRoom {
    ///Atributos
    public List<Room> collectionRoom = new ArrayList<>();

    ///Constructores
    public CollectionRoom(){
    }

    public CollectionRoom(List<Room> collectionRoom) {
        this.collectionRoom = collectionRoom;
    }

    ///Getter and Setter

    public List<Room> getCollectionRoom() {
        return collectionRoom;
    }

    public void setCollectionRoom(List<Room> collectionRoom) {
        this.collectionRoom = collectionRoom;
    }

    ///Metodos
}
