package com.company;

import java.util.ArrayList;
import java.util.List;

public class CollectionRoom {
    ///Atributos
    public List<Room> listRoom = new ArrayList<>();

    ///Constructores
    public CollectionRoom(){
    }

    public CollectionRoom(List<Room> collectionRoom) {
        this.listRoom = collectionRoom;
    }

    ///Getter and Setter


    public List<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }

    ///Metodos
    public void loadRooms(){
        Room room1 = new Room(1,StatusRoom.DISPONSABLE,2,600,"Minibar, Aire acondicionado, Cama de dos plazas King, TV Pantalla Plana, Vista al mar");
        Room room2 = new Room(2,StatusRoom.DISPONSABLE,3,700,"Caja Fuerte, Minibar, Aire acondicionado, Cama de dos plazas King y Cama Simple, TV Pantalla Plana, Vista al mar");
        Room room3 = new Room(3,StatusRoom.DISPONSABLE, 2, 500, "Minibar, Aire acondicionado, Cama de dos plazas King, TV Pantalla Plana" );
        Room room4 = new Room(4,StatusRoom.IN_REPAIR, 3, 700, "Minibar, Aire acondicionado, Cama de dos plazas King, TV Pantalla Plana");
      /*  Room room5 = new Room();Room room6 = new Room(); Room room7 = new Room(); Room room8 = new Room();
        Room room9 = new Room(); Room room10 = new Room(); Room room11 = new Room(); Room room12 = new Room();*/

        listRoom.add(room1);listRoom.add(room2);listRoom.add(room3);listRoom.add(room4); /*listRoom.add(room5);listRoom.add(room6);
        listRoom.add(room7);listRoom.add(room8); listRoom.add(room9);listRoom.add(room10);listRoom.add(room11);listRoom.add(room12);*/
    }

    public void totalRoom(){
        for (Room x: listRoom) {
            System.out.println(x.toString());
        }
    }

    public void availableRoom(){
        for (Room x: listRoom) {
            if(x.getAvailable().equals(StatusRoom.DISPONSABLE)){
                System.out.println(x.toString());
            }
        }
    }

}
