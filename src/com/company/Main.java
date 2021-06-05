package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.desktop.ScreenSleepEvent;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args){
        ///Menu
        CollectionUser listUser = new CollectionUser();

        Scanner scanner = new Scanner(System.in);

        char character;

        boolean quit = false;
        int option= 0;


        do {
            try {
                System.out.println("ROCKET HOTEL: \n");
                System.out.println("1)Login.\n2)Registrarse.\n\nOpcion: ");
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
                                System.out.println(user.toString());
                                if (user instanceof Client) {
                                    System.out.println("Usuario " + user.getUserName());
                                    System.out.println("\n1)Ver habitaciones disponibles.\n2)Realizar reserva.\n3)Listados de reservas anteriores." +
                                            "\n4)Cancelar reserva.\n5)Ver perfil.\n6)Modificar perfil.");
                                    option = scanner.nextInt();
                                    try{
                                        switch (option){
                                            case 1 -> {

                                            }
                                            case 2 -> {

                                            }
                                            case 3 -> {

                                            }
                                            case 4 -> {

                                            }
                                            case 5 -> {

                                            }
                                            case 6 -> {

                                            }
                                            default -> System.out.println("\nOpcion incorrecta.\n");
                                            }
                                     } catch (InputMismatchException e) {
                                    System.out.println("\nSe debe ingresar un numero.\n");
                                    scanner.next();
                                }
                                    }
                                    scanner.nextLine();
                                } else if (user instanceof Administrator) {

                                } else {

                                }


                                quit = true;
                            }
                            else {
                                System.out.println("\nUsuario / E-mail o contraseña incorrectos. Presione 'n' para salir o cualquier otra tecla para continuar.\n");
                                character = scanner.next().charAt(0);
                                if(character=='n'){
                                    quit= true;
                                }
                            }

                        }
                        while (!quit);
                    }
                    case 2 -> {
                        System.out.println("REGISTRARSE.\n");
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