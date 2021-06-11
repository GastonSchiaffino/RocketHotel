package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionRoom implements FileRocketHotel {
    ///Atributos
    List<Room> listRoom = new ArrayList<>();

    ///Metodos
    public void loadRooms(){
        Room room1 = new Room(1,StatusRoom.AVAILABLE,4,1200,"Minibar, Aire acondicionado, Cama de dos plazas King y dos camas simples, TV Pantalla Plana, Vista al mar, Wifi,Desayuno incluido");
        Room room2 = new Room(2,StatusRoom.AVAILABLE,3,950," Frigobar, Aire acondicionado, Cama de dos plazas King y Cama Simple, TV Pantalla Plana,Caja Fuerte, Vista al mar, Wifi,Desayuno incluido");
        Room room3 = new Room(3,StatusRoom.DISINFECTION, 2, 600, "Minibar, Aire acondicionado, Dos camas simples, TV Pantalla Plana, Wifi,Desayuno incluido" );
        Room room4 = new Room(4,StatusRoom.IN_REPAIR, 1, 350, "Minibar, Aire acondicionado, Cama simple, TV Pantalla Plana,Wifi,Desayuno incluido");
        Room room5 = new Room(5,StatusRoom.OCCUPIED,1,500,"Minibar, Aire acondicionado, Cama simple, TV Pantalla Plana,Wifi,All inclusive");
        Room room6 = new Room(6,StatusRoom.AVAILABLE,2,600,"Minibar, Aire acondicionado, Cama de dos plazas King, TV Pantalla Plana, Wifi,Desayuno incluido");
        Room room7 = new Room(7,StatusRoom.OCCUPIED,3,1050," Minibar, Aire acondicionado, Cama de dos plazas King y Cama Simple, TV Pantalla Plana,Caja Fuerte,Wifi,All inclusive");
        Room room8 = new Room(8,StatusRoom.OCCUPIED,4,1000,"Frigobar,Aire acondicionado, Cama de dos plazas King y dos camas simples, TV Pantalla Plana,Wifi,Desayuno incluido");
        Room room9 = new Room(9,StatusRoom.CLEANING,4,1500,"Frigobar,Aire acondicionado, Cama de dos plazas King y dos camas simples, TV Pantalla Plana,Wifi,All inclusive");
        Room room10 = new Room(10,StatusRoom.OCCUPIED,2,800,"Minibar, Aire acondicionado, Cama de dos plazas King, TV Pantalla Plana, Wifi,All inclusive");
        Room room11 = new Room(11,StatusRoom.AVAILABLE,3,850," Minibar, Aire acondicionado, Cama de dos plazas King y Cama Simple, TV Pantalla Plana,Caja Fuerte, Vista al mar,Wifi,Desayuno incluido");
        Room room12 = new Room(12,StatusRoom.AVAILABLE,1,350,"Minibar, Aire acondicionado, Cama simple, TV Pantalla Plana,Wifi,Desayuno incluido");

        listRoom.add(room1);listRoom.add(room2);listRoom.add(room3);listRoom.add(room4);listRoom.add(room5);listRoom.add(room6);
        listRoom.add(room7);listRoom.add(room8); listRoom.add(room9);listRoom.add(room10);listRoom.add(room11);listRoom.add(room12);
    }

    public void totalRoom(){
        for (Room x: listRoom) {
            System.out.println(x.toString());
        }
    }

    public void availableRoom(){
        for (Room x: listRoom) {
            if(x.getAvailable().equals(StatusRoom.AVAILABLE)){
                System.out.println(x.toString());
            }
        }
    }


    public void showListRoom(){
        for (Room x: listRoom) {
            System.out.println(x.toString());
        }
    }

    public void showListRoomAsCapacity(int capacity){
        for (Room x: listRoom) {
            if(x.getCapacity()==capacity)
                System.out.println(x.toString());
        }
    }
    public List<Room> searchForCapacity(int capacity){
        List<Room> rooms=null;
        for(Room x: listRoom){
            if(x.getCapacity()==capacity){
                rooms.add(x);
            }
        }
        return rooms;
    }

    public Room searchRoom(int idRoom){
        Room room= null;
        for (Room x:listRoom) {
            if(x.getIdRoom()==idRoom){
                room= x;
            }
        }
        return room;
    }

    public void roomModify(int idRoom) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        for (Room x : listRoom) {
            if (x.getIdRoom() == (idRoom)) {
                do {
                    System.out.println("Ingrese la opcion que desea modificar: \n");
                    System.out.println("1)Precio.\n2)Descripcion.\n\n0)Salir.\n\nOpcion: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1 -> {
                            System.out.println("Precio: ");
                            x.setPriceForDay(scanner.nextInt());
                        }
                        case 2 -> {
                            System.out.println("Descripcion: ");
                            x.setDescription(scanner.nextLine());
                        }
                        case 0 -> {
                            System.out.println("\n");
                        }
                        default -> System.out.println("\nOpcion incorrecta.\n");
                    }
                }
                while (opcion != 0);
            }
        }
    }

    public void ocuppiedRoom(){
        for (Room x: listRoom) {
            if(x.getAvailable().equals(StatusRoom.OCCUPIED)){
                System.out.println(x.toString());

            }
        }
    }

    @Override
    public void read(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if(file.length()>0)
            listRoom = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Room.class));
    }


    @Override
    public void write(File file)  throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, listRoom);
    }
}