package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        ///Menu
        CollectionUser listUser = new CollectionUser();
        CollectionRoom listRoom= new CollectionRoom();
        CollectionReservation listReservation= new CollectionReservation();
        CollectionConsumption listConsumption= new CollectionConsumption();

        File fileAdmin = new File("Admin_rockethotel.json");
        File fileReceptionist = new File("Receptionist_rockethotel.json");
        File fileClient = new File("Client_rockethotel.json");
        File fileRoom = new File("room_rockethotel.json");
        File fileReservation = new File("reservation_rockethotel.json");
        File fileConsumption = new File("consumption_rockethotel.json");


        File backupAdmin = new File("C:\\Users\\mosta\\Desktop\\FACULTAD\\Programacion III\\Practica Java\\RocketHotel\\backup\\backupadm.json");
        File backupReceptionist = new File("C:\\Users\\mosta\\Desktop\\FACULTAD\\Programacion III\\Practica Java\\RocketHotel\\backup\\backupreceptionist.json");
        File backupClient = new File("C:\\Users\\mosta\\Desktop\\FACULTAD\\Programacion III\\Practica Java\\RocketHotel\\backup\\backupclient.json");
        File backupRoom = new File("C:\\Users\\mosta\\Desktop\\FACULTAD\\Programacion III\\Practica Java\\RocketHotel\\backup\\backuproom.json");
        File backupReservation = new File("C:\\Users\\mosta\\Desktop\\FACULTAD\\Programacion III\\Practica Java\\RocketHotel\\backup\\backupreservation.json");
        File backupConsumption = new File("C:\\Users\\mosta\\Desktop\\FACULTAD\\Programacion III\\Practica Java\\RocketHotel\\backup\\backupconsumption.json");


        if(!fileAdmin.exists()) {
            fileAdmin.createNewFile();
            Administrator administratorPrincipal = new Administrator("admin", "admin", "12345", "indefinido", "argentina", "Rocket Hotel", "admin", "admin", "admin@gmail.com", true, 0, 0);
            listUser.addUser(administratorPrincipal);
            listUser.writeAdmin(fileAdmin);
        } else {
            listUser.readAdmin(fileAdmin);
        }

        if(!fileReceptionist.exists()) {
            fileReceptionist.createNewFile();
            listUser.writeRecep(fileReceptionist);
        } else
            listUser.readRecep(fileReceptionist);

        if(!fileClient.exists()) {
            fileClient.createNewFile();
            listUser.writeClient(fileClient);
        } else
            listUser.readClient(fileClient);

        if(!fileRoom.exists()) {
            fileRoom.createNewFile();
            listRoom.loadRooms();
            listRoom.write(fileRoom);
        } else
            listRoom.read(fileRoom);

        if(!fileReservation.exists()) {
            fileReservation.createNewFile();
        } else
            listReservation.read(fileReservation);

        if(!fileConsumption.exists()) {
            fileConsumption.createNewFile();
            listConsumption.loadConsumption();
            listConsumption.write(fileConsumption);
        } else
            listConsumption.read(fileConsumption);

        Scanner scanner = new Scanner(System.in);

        User user= new User();

        char character = 0;
        String textInput;
        int option= 0;
        char optionChar;
        boolean quit = false;
        boolean quitProgram= false;

        do {
            try {
                option= 0;
                quit = false;
                System.out.println("ROCKET HOTEL: \n");
                System.out.println("1)Login.\n0)Salir.\n\nOpcion: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1 -> {
                        do {
                            quit= false;
                            System.out.println("LOGIN.");

                            System.out.println("\nNombre de usuario o E-mail: ");
                            String userName = scanner.next();
                            System.out.println("\nPassword: ");
                            String password = scanner.next();
                            user = listUser.loginUser(userName, password);
                            if (user != null) {
                                if(listUser.searchClient(user.getDni())!=null) {
                                    do {
                                        System.out.println("Usuario " + user.getUserName());
                                        System.out.println("""

                                                1)Ver habitaciones.
                                                2)Realizar reserva.
                                                3)Reserva actual.
                                                4)Listados de reservas.
                                                5)Cancelar reserva.
                                                6)Ver perfil.
                                                7)Modificar perfil.
                                                8)Consumir.

                                                0)Salir.
                                                """);

                                        option = scanner.nextInt();
                                        try {
                                            switch (option) {
                                                case 1 -> {
                                                    System.out.println("Habitaciones:\n");
                                                    listRoom.showListRoom();
                                                }
                                                case 2 -> {
                                                    do {
                                                        quit = false;
                                                        System.out.println("Ingrese el numero de personas(capacidad minima 1 / capacidad maxima 4): ");
                                                        option = scanner.nextInt();
                                                        if (option > 0 && option < 5) {
                                                            do {
                                                                System.out.println("\nIngrese la fecha de ingreso(dd/mm/yyyy): ");
                                                                String entry = scanner.next();
                                                                System.out.println("\nIngrese la fecha de egreso(dd/mm/yyyy): ");
                                                                String exit = scanner.next();
                                                                List<Room> roomsAvailable = listReservation.searchRoomsForReservation(listRoom.searchForCapacity(option), entry, exit);
                                                                for (Room x : roomsAvailable) {
                                                                    System.out.println(x.toString());
                                                                }
                                                                do {
                                                                    System.out.println("Ingrese la habitacion que desea reservar: ");
                                                                    option = scanner.nextInt();
                                                                    for (Room x : roomsAvailable) {
                                                                        if (x.getIdRoom() == option) {
                                                                            System.out.println("\nReserva realizada");
                                                                            Reservation reservationDone = new Reservation(user.getDni(), option, entry, exit, false);
                                                                            listReservation.addReservation(reservationDone);
                                                                            listReservation.write(fileReservation);
                                                                            quit = true;
                                                                        }
                                                                    }
                                                                    if(!quit){
                                                                        System.out.println("\nLa habitacion seleccionada no se encuentra disponible.");
                                                                    }
                                                                } while (!quit);
                                                            }
                                                            while (!quit);
                                                        } else {
                                                            System.out.println("La opcion ingresada es incorrecta. Presione 'n' para salir o cualquier otra tecla para volver a ingresar la capacidad.\n");
                                                            character = scanner.next().charAt(0);
                                                        }
                                                    }
                                                    while (!quit && character != 'n');

                                                }
                                                case 3 -> {
                                                    System.out.println("Reserva actual:\n");
                                                    List<Reservation> reservations = listReservation.searchReservationCurrent(user.getDni());
                                                    for (Reservation x : reservations) {
                                                        System.out.println(x.toString());
                                                    }
                                                }
                                                case 4 -> {
                                                    System.out.println("Historial de reservas:\n");
                                                    List<Reservation> reservationsClient = new ArrayList<>();
                                                    reservationsClient = listReservation.searchReservationHistory(user.getDni());
                                                    reservationsClient.forEach(System.out::println);
                                                }
                                                case 5 -> {
                                                    System.out.println("Reserva/s actual/es: ");
                                                    character = 's';
                                                    List<Reservation> reservationsClient = new ArrayList<>();
                                                    reservationsClient = listReservation.searchReservationCurrent(user.getDni());
                                                    reservationsClient.forEach(System.out::println);
                                                    do {
                                                        if (!reservationsClient.isEmpty()) {
                                                            option = scanner.nextInt();
                                                            Reservation reservation = listReservation.searchReservation(option);
                                                            if (reservation != null) {
                                                                listReservation.cancelledReservartion(option);
                                                                System.out.println("\nReserva cancelada.");
                                                                listReservation.write(fileReservation);
                                                            } else {
                                                                System.out.println("El numero de reserva ingresado es incorrecto. Presione 's' para volver a intentarlo o cualquier otra tecla para salir.\n");
                                                                character = scanner.next().charAt(0);
                                                            }
                                                        }else {
                                                            System.out.println("No posee reservas vigentes.\n");
                                                            character='n';
                                                        }
                                                    } while (character == 's');
                                                }
                                                case 6 -> {
                                                    System.out.println("Perfil del cliente: \n");
                                                    System.out.println(user.toString());
                                                }
                                                case 7 -> {
                                                    System.out.println("Modificar datos: ");
                                                    listUser.userModify(user.getDni());
                                                    listUser.writeClient(fileClient);
                                                }
                                                case 8->{
                                                    System.out.println("Menu: ");
                                                    listConsumption.showListConsumition();
                                                    System.out.println("Ingrese el id de lo que desea consumir: ");
                                                    option= scanner.nextInt();
                                                    Consumption consumption;
                                                    consumption= listConsumption.searchConsumption(option);
                                                    System.out.println(consumption.toString());

                                                }
                                                case 0 -> {
                                                    System.out.println("\n");
                                                    quit= true;
                                                }
                                                default -> System.out.println("\nOpcion incorrecta.\n");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("\nSe debe ingresar un numero.\n");
                                            scanner.next();
                                        }
                                    }while (option!=0 && !quit);
                                } else if (listUser.searchAdministrator(user.getDni())!=null || listUser.searchReceptionist(user.getDni())!=null) {
                                    quit=false;
                                    try{
                                        do {
                                            System.out.println("Miembro de staff: " + user.getUserName());
                                            if(listUser.searchAdministrator(user.getDni())!=null) {
                                                System.out.println("""

                                                1)Ver habitaciones.
                                                2)Ver reservas vigentes.
                                                3)Buscar reserva especifica.
                                                4)Buscar un cliente.
                                                5)Buscar un administrador.
                                                6)Buscar un recepcionista.
                                                7)Buscar una habitacion.
                                                8)Comidas y bebidas.
                                                9)Listados.                                       
                                                10)Generar reserva.
                                                11)Registrar nuevos usuarios.
                                                12)Ver perfil.
                                                13)Modificar perfil.
                                                14)Back up.
                                                15)Restaurar datos a partir de su ultima copia de seguridad.

                                                0)Salir.
                                                """);
                                            }
                                            else {
                                                System.out.println("""

                                                1)Ver habitaciones.
                                                2)Ver reservas vigentes.
                                                3)Buscar reserva especifica.
                                                4)Buscar un cliente.
                                                5)Buscar un administrador.
                                                6)Buscar un recepcionista.
                                                7)Buscar una habitacion.
                                                8)Comidas y bebidas.
                                                9)Listados.                                       
                                                10)Ver perfil.
                                                11)Modificar perfil.

                                                0)Salir.
                                                """);
                                            }
                                            option = scanner.nextInt();
                                            switch (option) {
                                                case 1 -> {
                                                    System.out.println("Habitaciones:\n");
                                                    listRoom.showListRoom();
                                                }
                                                case 2 -> {
                                                    System.out.println("Reservas vigentes:\n");
                                                    listReservation.showListReservationCurrent();
                                                }
                                                case 3 -> {
                                                    System.out.println("Buscar reserva:\n1)Por DNI.\n2)Por numero de reserva.\n0)Salir.\n");
                                                    option = scanner.nextInt();
                                                    try {
                                                        switch (option) {
                                                            case 1 -> {
                                                                do {
                                                                    System.out.println("Ingrese el numero de DNI: ");
                                                                    textInput = scanner.next();
                                                                    Reservation reservation = listReservation.searchReservationAsDni(textInput);
                                                                    if (reservation == null) {
                                                                        System.out.println("No existe ninguna reserva asignada al DNI ingresado. Presione 's' para ingresar otro DNI o cualquier otra tecla para salir.\n");
                                                                        character = scanner.next().charAt(0);
                                                                    } else {
                                                                        System.out.println(reservation.toString());
                                                                        character = 'n';
                                                                    }
                                                                } while (character == 's');
                                                            }
                                                            case 2 -> {
                                                                do {
                                                                    System.out.println("Ingrese el numero de reserva: ");
                                                                    option = scanner.nextInt();
                                                                    Reservation reservation = listReservation.searchReservation(option);
                                                                    if (reservation == null) {
                                                                        System.out.println("No existe ninguna reserva con bajo ese numero de identificacion. Presione 's' para ingresar otro numero de reserva o cualquier otra tecla para salir.\n");
                                                                        character = scanner.next().charAt(0);
                                                                    } else {
                                                                        System.out.println(reservation.toString());
                                                                        character = 'n';
                                                                    }
                                                                } while (character == 's');
                                                            }
                                                            case 0 -> {
                                                                System.out.println("\n");
                                                            }
                                                            default -> System.out.println("\nOpcion incorrecta.\n");
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("\nSe debe ingresar un numero.\n");
                                                        scanner.next();
                                                    }
                                                }
                                                case 4 -> {
                                                    do {
                                                        System.out.println("Busqueda de clientes.\n");
                                                        System.out.println("Ingrese el DNI del cliente que desea buscar: ");
                                                        textInput = scanner.next();
                                                        Client client = listUser.searchClient(textInput);
                                                        if (client == null) {
                                                            System.out.println("No existe ningun cliente con el DNI indicado. Presione 's' para ingresar otro DNI o cualquier otra tecla para salir.\n");
                                                            character = scanner.next().charAt(0);
                                                        } else {
                                                            System.out.println(client.toString());
                                                            System.out.println("\nSi desea modificar al cliente presione 'm', de lo contrario cualquier otra tecla para continuar.\n");
                                                            character = scanner.next().charAt(0);
                                                            if (character == 'm') {
                                                                listUser.userModify(textInput);
                                                                listUser.writeClient(fileClient);
                                                            }
                                                            character = 'n';
                                                        }
                                                    } while (character == 's');
                                                }
                                                case 5 -> {
                                                    do {
                                                        System.out.println("Busqueda de administrador.\n");
                                                        System.out.println("Ingrese el DNI del administrador que desea buscar: ");
                                                        textInput = scanner.next();
                                                        Administrator administrator = listUser.searchAdministrator(textInput);
                                                        if (administrator == null) {
                                                            System.out.println("No existe ningun administrador con el DNI indicado. Presione 's' para ingresar otro DNI o cualquier otra tecla para salir.\n");
                                                            character = scanner.next().charAt(0);
                                                        } else {
                                                            System.out.println(administrator.toString());
                                                            System.out.println("\nSi desea modificar al administrador presione 'm', de lo contrario cualquier otra tecla para continuar.\n");
                                                            character = scanner.next().charAt(0);
                                                            if (character == 'm') {
                                                                listUser.userModify(textInput);
                                                                listUser.writeAdmin(fileAdmin);
                                                            }
                                                            character = 'n';
                                                        }
                                                    } while (character == 's');
                                                }
                                                case 6 -> {
                                                    do {
                                                        System.out.println("Busqueda de recepcionista.\n");
                                                        System.out.println("Ingrese el DNI del recepcionista que desea buscar: ");
                                                        textInput = scanner.next();
                                                        Receptionist receptionist = listUser.searchReceptionist(textInput);
                                                        if (receptionist == null) {
                                                            System.out.println("No existe ningun recepcionista con el DNI indicado. Presione 's' para ingresar otro DNI o cualquier otra tecla para salir.\n");
                                                            character = scanner.next().charAt(0);
                                                        } else {
                                                            System.out.println(receptionist.toString());
                                                            System.out.println("\nSi desea modificar al recepcionista presione 'm', de lo contrario cualquier otra tecla para continuar.\n");
                                                            character = scanner.next().charAt(0);
                                                            if (character == 'm') {
                                                                listUser.userModify(textInput);
                                                                listUser.writeRecep(fileReceptionist);
                                                            }
                                                            character = 'n';
                                                        }
                                                    } while (character == 's');
                                                }
                                                case 7 -> {
                                                    do {
                                                        System.out.println("Busqueda de habitacion.\n");
                                                        System.out.println("Ingrese el numero de identificacion de la habitacion que desea buscar: ");
                                                        option = scanner.nextInt();
                                                        Room room = listRoom.searchRoom(option);
                                                        if (room == null) {
                                                            System.out.println("No existe ninguna habitacion con ese numero de identificacion. Presione 's' para ingresar otro DNI o cualquier otra tecla para salir.\n");
                                                            character = scanner.next().charAt(0);
                                                        } else {
                                                            System.out.println(room.toString());
                                                            System.out.println("\nSi desea modificar algun item de la habitacion presione 'm', de lo contrario cualquier otra tecla para continuar.\n");
                                                            character = scanner.next().charAt(0);
                                                            if (character == 'm') {
                                                                listRoom.roomModify(option);
                                                                listRoom.write(fileRoom);
                                                            }
                                                            character = 'n';
                                                        }
                                                    } while (character == 's');
                                                }
                                                case 8 -> {
                                                    System.out.println("Comidas y bebidas.\n");
                                                    listConsumption.showListConsumition();
                                                    System.out.println("\nSi desea modificar alguna bebida o comida presione 'm', de lo contrario cualquier otra tecla para salir.\n");
                                                    character = scanner.next().charAt(0);
                                                    if (character == 'm') {
                                                        do {
                                                            System.out.println("Ingrese el identificador que quiera modificar: ");
                                                            option = scanner.nextInt();
                                                            Consumption consumption = listConsumption.searchConsumption(option);
                                                            if (consumption == null) {
                                                                System.out.println("No existe ninguna bebida o comida con ese numero de identificacion. Presione 's' para ingresar otro identificador o cualquier otra tecla para salir.\n");
                                                                character = scanner.next().charAt(0);
                                                            } else {
                                                                System.out.println(consumption.toString());
                                                                System.out.println("Ingrese el nuevo precio del producto: ");
                                                                double price = scanner.nextInt();
                                                                listConsumption.modifyPriceConsumption(option, price);
                                                                listConsumption.write(fileConsumption);
                                                                character = 'n';
                                                            }
                                                        }
                                                        while (character == 's');
                                                    }
                                                }
                                                case 9 -> {
                                                    char exitList= 's';
                                                    do {
                                                        System.out.println("Listados:\n");
                                                        System.out.println("""

                                                                1)Listado de administradores.
                                                                2)Listado de recepcionistas.
                                                                3)Listado de clientes.
                                                                4)Listado de habitaciones.
                                                                5)Listado de reservas.

                                                                0)Salir.
                                                                """);
                                                        option = scanner.nextInt();
                                                        try {
                                                            switch (option) {
                                                                case 1 -> {
                                                                    System.out.println("Listado de administradores:\n");
                                                                    listUser.showListAdministrator();
                                                                }
                                                                case 2 -> {
                                                                    System.out.println("Listado de recepcionistas:\n");
                                                                    listUser.showListRecepcionist();
                                                                }
                                                                case 3 -> {
                                                                    System.out.println("Listado de clientes:\n");
                                                                    listUser.showListClient();
                                                                }
                                                                case 4 -> {
                                                                    System.out.println("Listado de habitaciones:\n");
                                                                    listRoom.showListRoom();
                                                                }
                                                                case 5 -> {
                                                                    System.out.println("Listado de reservas:\n");
                                                                    listReservation.showListReservationCurrent();
                                                                }
                                                                case 0 -> {
                                                                    System.out.println("\n");
                                                                    option=1;
                                                                    exitList= 'n';

                                                                }
                                                                default -> System.out.println("\nOpcion incorrecta.\n");
                                                            }
                                                        } catch (InputMismatchException e) {
                                                            System.out.println("\nSe debe ingresar un numero.\n");
                                                            scanner.next();
                                                        }
                                                    } while (exitList=='s');

                                                }
                                                case 10 -> {
                                                    if (user instanceof Administrator) {
                                                        do {
                                                            System.out.println("Generar reserva.\n");
                                                            quit = false;
                                                            System.out.println("Ingrese el numero de personas(capacidad minima 1 / capacidad maxima 4): ");
                                                            option = scanner.nextInt();
                                                            if (option > 0 && option < 5) {
                                                                do {
                                                                    System.out.println("\nIngrese la fecha de ingreso: ");
                                                                    String entry = scanner.next();
                                                                    System.out.println("\nIngrese la fecha de egreso: ");
                                                                    String exit = scanner.next();
                                                                    List<Room> roomsAvailable = listReservation.searchRoomsForReservation(listRoom.searchForCapacity(option), entry, exit);
                                                                    for (Room x : roomsAvailable) {
                                                                        System.out.println(x.toString());
                                                                    }
                                                                    do {
                                                                        System.out.println("Ingrese la habitacion que desea reservar: ");
                                                                        option = scanner.nextInt();
                                                                        for (Room x : roomsAvailable) {
                                                                            if (x.getIdRoom() == option) {
                                                                                System.out.println("\nIngrese el dni del cliente para asignar la reserva: ");
                                                                                String dniClient = scanner.next();
                                                                                Reservation reservationDone = new Reservation(dniClient, option, entry, exit, false);
                                                                                System.out.println("\nReserva realizada");
                                                                                listReservation.addReservation(reservationDone);
                                                                                listReservation.write(fileReservation);
                                                                                quit = true;
                                                                            }
                                                                        }
                                                                        if(!quit){
                                                                            System.out.println("\nLa habitacion seleccionada no se encuentra disponible.");
                                                                        }
                                                                    } while (!quit);
                                                                }
                                                                while (!quit);
                                                            } else {
                                                                System.out.println("La opcion ingresada es incorrecta. Presione 'n' para salir o cualquier otra tecla para volver a ingresar la capacidad.\n");
                                                                character = scanner.next().charAt(0);
                                                            }
                                                        }
                                                        while (!quit && character != 'n');
                                                    }
                                                }
                                                case 11 -> {
                                                    if (user instanceof Administrator) {
                                                        character = 's';

                                                        do {
                                                            System.out.println("REGISTRAR USUARIO.\n");
                                                            try {
                                                                System.out.println("\n1)Cliente.\n2)Recepcionista.\n3)Administrador.\n\n0)Salir.\n");
                                                                option = scanner.nextInt();
                                                                User userAux;
                                                                User userAux2;
                                                                User userAux3;
                                                                quit = false;
                                                                switch (option) {
                                                                    case 1 -> {
                                                                        do {
                                                                            Client clientNew = new Client();
                                                                            clientNew.register();
                                                                            userAux = listUser.searchUser(clientNew.getDni());
                                                                            userAux2 = listUser.searchUserAsUserName(clientNew.getUserName());
                                                                            userAux3 = listUser.searchUserAsMail(clientNew.getEmailAddress());
                                                                            if (userAux != null || userAux2 != null || userAux3 != null) {
                                                                                if (userAux != null) {
                                                                                    System.out.println("\nEl dni ya se encuentra registrado en la base de datos.\n");
                                                                                }
                                                                                if (userAux2 != null) {
                                                                                    System.out.println("\nEl nombre de usuario ya se encuentra registrado en la base de datos.\n");
                                                                                }
                                                                                if (userAux3 != null) {
                                                                                    System.out.println("\nEl e-mail ya se encuentra registrado en la base de datos.\n");
                                                                                }
                                                                            } else {
                                                                                System.out.println("\nCliente registrado correctamente.\n");
                                                                                listUser.addUser(clientNew);
                                                                                listUser.writeClient(fileClient);

                                                                                quit = true;
                                                                            }
                                                                        } while (!quit);
                                                                    }
                                                                    case 2 -> {
                                                                        do {
                                                                            Receptionist receptionistNew = new Receptionist();
                                                                            receptionistNew.register();
                                                                            userAux = listUser.searchUser(receptionistNew.getDni());
                                                                            userAux2 = listUser.searchUserAsUserName(receptionistNew.getUserName());
                                                                            userAux3 = listUser.searchUserAsMail(receptionistNew.getEmailAddress());
                                                                            if (userAux != null || userAux2 != null || userAux3 != null) {
                                                                                if (userAux != null) {
                                                                                    System.out.println("\nEl dni ya se encuentra registrado en la base de datos.\n");
                                                                                }
                                                                                if (userAux2 != null) {
                                                                                    System.out.println("\nEl nombre de usuario ya se encuentra registrado en la base de datos.\n");
                                                                                }
                                                                                if (userAux3 != null) {
                                                                                    System.out.println("\nEl e-mail ya se encuentra registrado en la base de datos.\n");
                                                                                }
                                                                            } else {
                                                                                System.out.println("\nRecepcionista registrado correctamente.\n");
                                                                                listUser.addUser(receptionistNew);
                                                                                listUser.writeRecep(fileReceptionist);

                                                                                quit = true;
                                                                            }
                                                                        } while (!quit);
                                                                    }
                                                                    case 3 -> {
                                                                        do {
                                                                            Administrator administratorNew = new Administrator();
                                                                            administratorNew.register();
                                                                            userAux = listUser.searchUser(administratorNew.getDni());
                                                                            userAux2 = listUser.searchUserAsUserName(administratorNew.getUserName());
                                                                            userAux3 = listUser.searchUserAsMail(administratorNew.getEmailAddress());
                                                                            if (userAux != null || userAux2 != null || userAux3 != null) {
                                                                                if (userAux != null) {
                                                                                    System.out.println("\nEl dni ya se encuentra registrado en la base de datos.\n");
                                                                                }
                                                                                if (userAux2 != null) {
                                                                                    System.out.println("\nEl nombre de usuario ya se encuentra registrado en la base de datos.\n");
                                                                                }
                                                                                if (userAux3 != null) {
                                                                                    System.out.println("\nEl e-mail ya se encuentra registrado en la base de datos.\n");
                                                                                }
                                                                            } else {
                                                                                System.out.println("\nAdministrador registrado correctamente.\n");
                                                                                listUser.addUser(administratorNew);
                                                                                listUser.writeAdmin(fileAdmin);

                                                                                quit = true;
                                                                            }
                                                                        } while (!quit);
                                                                    }
                                                                    case 0 -> {
                                                                        System.out.println("\n");
                                                                    }
                                                                    default -> System.out.println("\nOpcion incorrecta.\n");
                                                                }

                                                            } catch (InputMismatchException e) {
                                                                System.out.println("\nSe debe ingresar un numero.\n");
                                                                scanner.next();
                                                            }
                                                        }
                                                        while (option != 0);
                                                    }
                                                }
                                                case 12 -> {
                                                    if(user instanceof Administrator) {
                                                        System.out.println("Perfil del administrador.\n");
                                                        System.out.println(user.toString());
                                                    }
                                                }
                                                case 13 -> {
                                                    if(user instanceof Administrator) {
                                                        System.out.println("Modificar datos: ");
                                                        listUser.userModify(user.getDni());
                                                        listUser.writeAdmin(fileAdmin);
                                                    }
                                                }
                                                case 14 -> {
                                                    if (user instanceof Administrator) {
                                                        System.out.println("Back up realizado.\n");

                                                        ((Administrator) user).fileToBackup(fileAdmin, backupAdmin);
                                                        ((Administrator) user).fileToBackup(fileClient, backupClient);
                                                        ((Administrator) user).fileToBackup(fileRoom, backupRoom);
                                                        ((Administrator) user).fileToBackup(fileConsumption, backupConsumption);
                                                        ((Administrator) user).fileToBackup(fileReceptionist, backupReceptionist);
                                                        ((Administrator) user).fileToBackup(fileReservation, backupReservation);
                                                    }
                                                }
                                                case 15 ->{
                                                    if (user instanceof Administrator) {
                                                        System.out.println("Se restauro la ultima copia de seguridad.\n");

                                                        ((Administrator) user).fileToBackup(backupAdmin, fileAdmin);
                                                        ((Administrator) user).fileToBackup(backupClient, fileClient);
                                                        ((Administrator) user).fileToBackup(backupRoom, fileRoom);
                                                        ((Administrator) user).fileToBackup(backupConsumption, fileConsumption);
                                                        ((Administrator) user).fileToBackup(backupReceptionist, fileReceptionist);
                                                        ((Administrator) user).fileToBackup(backupReservation, fileReservation);
                                                    }
                                                }
                                                case 0 -> {
                                                    System.out.println("\n");
                                                    quit= true;
                                                }
                                                default -> System.out.println("\nOpcion incorrecta.\n");
                                            }
                                        }while (option!=0 && !quit);
                                    }
                                    catch (InputMismatchException e) {
                                        System.out.println("\nSe debe ingresar un numero.\n");
                                        scanner.next();
                                    }
                                }
                            } else {
                                System.out.println("\nUsuario / E-mail o contraseña incorrectos. Presione 'n' para salir o cualquier otra tecla para continuar.\n");
                                character = scanner.next().charAt(0);
                                if (character == 'n') {
                                    quit = true;
                                }
                            }

                        }
                        while (!quit);
                    }
                    case 0 -> {
                        quitProgram= true;
                    }
                    default -> System.out.println("\nOpcion incorrecta.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nSe debe ingresar un numero.\n");
                scanner.next();
            }
        }
        while (!quitProgram);
    }


}

