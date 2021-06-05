package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ///Menu
        User user = new User();

        CollectionUser users = new CollectionUser();

       // user.register();

        Scanner scanner= new Scanner(System.in);
        boolean salir= false;
        int opcion;

        do {
            try {
                System.out.println("Menu: \n");
                System.out.println("1)Login.\n2)Registrarse.\n\nOpcion: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> {
                        System.out.println("LOGIN.\n");
                        System.out.println(user.login());
                        System.out.println(user.toString());
                        salir = true;
                    }
                    case 2 -> {
                        System.out.println("REGISTRARSE.\n");
                        Client client = new Client();
                        users.register(client);
                        users.addUser(client);
                        salir = true;
                    }
                    default -> System.out.println("\nOpcion incorrecta.\n");
                }
            }catch(InputMismatchException e){
                System.out.println("\nSe debe ingresar un numero.\n");
                scanner.next();
            }
        }
        while(!salir);

    }

}
