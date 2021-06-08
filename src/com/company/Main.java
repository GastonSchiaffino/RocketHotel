package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.desktop.ScreenSleepEvent;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args){
        ///Menu
        CollectionUser listUser = new CollectionUser();
        CollectionRoom listRoom= new CollectionRoom();
        CollectionReservation listReservation= new CollectionReservation();

        listRoom.loadRooms();

        listRoom.availableRoom();


        Scanner scanner = new Scanner(System.in);

        char character = 0;
        String textInput;
        int option= 0;
        boolean quit = false;


        do {
            try {
                option= 0;
                quit = false;
                System.out.println("ROCKET HOTEL: \n");
                System.out.println("1)Login.\n2)Registrarse.\n0)Salir.\n\nOpcion: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> {
                        System.out.println("LOGIN.");
                        do {
                            System.out.println("\nNombre de usuario o E-mail: ");
                            String userName = scanner.nextLine();
                            System.out.println("\nPassword: ");
                            String password = scanner.nextLine();
                            User user = listUser.loginUser(userName, password);
                            if (user != null) {
                                if (user instanceof Client) {
                                    System.out.println("Usuario " + user.getUserName());
                                    System.out.println("""

                                            1)Ver habitaciones.
                                            2)Realizar reserva.
                                            3)Reserva actual.
                                            4)Listados de reservas.
                                            5)Cancelar reserva.
                                            6)Ver perfil.
                                            7)Modificar perfil.

                                            0)Salir.
                                            """);
                                    option = scanner.nextInt();
                                    try {
                                        switch (option) {
                                            case 1 -> {
                                                System.out.println("Habitaciones:\n");
                                                listRoom.loadRooms();
                                            }
                                            case 2 -> {
                                                System.out.println("Habitaciones disponibles:\n");
                                                listRoom.loadRooms();
                                                System.out.println("");
                                                option= scanner.nextInt();
                                                if(0<option && option<13){
                                                    System.out.println("\nIngrese la fecha de ingreso: ");
                                                    String entry= scanner.nextLine();
                                                    System.out.println("\nIngrese la fecha de egreso: ");
                                                    String exit= scanner.nextLine();


                                                    Reservation reservation= new Reservation(user.getDni(), option, LocalDate.parse(entry), LocalDate.parse(exit),true);
                                                }

                                            }
                                            case 3 -> {
                                                System.out.println("Reserva actual:\n");

                                            }
                                            case 4 -> {
                                                System.out.println("Historial de reservas:\n");
                                                List <Reservation> reservationsClient= new ArrayList<>();
                                                reservationsClient= listReservation.searchReservationHistory(user.getDni());
                                                reservationsClient.forEach(System.out::println);
                                            }
                                            case 5 -> {
                                                System.out.println("Reserva/s actual/es: ");
                                                List <Reservation> reservationsClient= new ArrayList<>();
                                                reservationsClient= listReservation.searchReservationCurrent(user.getDni());
                                                reservationsClient.forEach(System.out::println);
                                                do {
                                                    option = scanner.nextInt();
                                                    Reservation reservation = listReservation.searchReservation(option);
                                                    if (reservation != null) {
                                                        listReservation.cancelledReservartion(option);
                                                    } else {
                                                        System.out.println("El numero de reserva ingresado es incorrecto. Presione 's' para volver a intentarlo o cualquier otra tecla para salir.\n");
                                                        character= scanner.next().charAt(0);
                                                    }
                                                }while(character=='s');
                                            }
                                            case 6 -> {
                                                System.out.println("Perfil: \n");
                                                System.out.println(user.toString());
                                            }
                                            case 7 -> {
                                                System.out.println("Modificar datos: ");
                                                listUser.userModify(user.getDni());
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
                                } else if (user instanceof Administrator) {

                                } else {
                                }

                                quit = true;
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
                    case 2 -> {
                        System.out.println("REGISTRARSE.\n");
                        User user= new User();
                        listUser.register(user);
                        listUser.addUser(user);

                        quit = true;
                    }
                    case 0 -> {
                        quit = true;
                    }
                    default -> System.out.println("\nOpcion incorrecta.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nSe debe ingresar un numero.\n");
                scanner.next();
            }
        }
        while (!quit && option == 0);

    }
}