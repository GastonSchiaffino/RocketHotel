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
    public void loadRooms(){
        Room room1 = new Room(1,StatusRoom.DISPONSABLE,2,600,"Minibar, Aire acondicionado, Cama de dos plazas King, TV Pantalla Plana, Vista al mar");
        Room room2 = new Room(2,StatusRoom.DISPONSABLE,3,700,"Caja Fuerte, Minibar, Aire acondicionado, Cama de dos plazas King y Cama Simple, TV Pantalla Plana, Vista al mar");
        Room room3 = new Room(3,StatusRoom.DISPONSABLE, 2, 500, "Minibar, Aire acondicionado, Cama de dos plazas King, TV Pantalla Plana" );
        Room room4 = new Room(4,StatusRoom.IN_REPAIR, 3, 700, "Minibar, Aire acondicionado, Cama de dos plazas King, TV Pantalla Plana");
        Room room5 = new Room();Room room6 = new Room(); Room room7 = new Room(); Room room8 = new Room();
        Room room9 = new Room(); Room room10 = new Room(); Room room11 = new Room(); Room room12 = new Room();

        collectionRoom.add(room1);collectionRoom.add(room2);collectionRoom.add(room3);collectionRoom.add(room4); collectionRoom.add(room5);collectionRoom.add(room6);
        collectionRoom.add(room7);collectionRoom.add(room8); collectionRoom.add(room9);collectionRoom.add(room10);collectionRoom.add(room11);collectionRoom.add(room12);
    }


}
