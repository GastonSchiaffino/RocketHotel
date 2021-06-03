package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ///Menu
        User user = new User();
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
                    case 1:
                        System.out.println("LOGIN.\n");
                        System.out.println(user.login());
                        System.out.println(user.toString());
                        salir= true;
                        break;

                    case 2:
                        System.out.println("REGISTRARSE.\n");
                        salir= true;
                        break;

                    default:
                        System.out.println("\nOpcion incorrecta.\n");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("\nSe debe ingresar un numero.\n");
                scanner.next();
            }
        }
        while(!salir);

    }
}
