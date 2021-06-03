package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ///Menu
        Scanner scanner= new Scanner(System.in);
        boolean salir= false;
        int opcion;

        do {
            try {
                System.out.println("Menu: \n");
                System.out.println("Ingresar: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ayuda");
                        salir= true;
                        break;

                    case 2:
                        System.out.println("Ayuda2");
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
