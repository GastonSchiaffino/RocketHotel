package com.company;

import java.util.List;
import java.util.Scanner;

public class Client extends User implements ReservationStatus,Discount {
    ///Atributos
    boolean vip;

    //Constructores
    public Client(){
        super();
    }

    public Client(String name, String surname, String dni, String gender, String origin, String address, String userName, String password, String emailAddress, boolean vip) {
        super(name, surname, dni, gender, origin, address, userName, password, emailAddress);
        this.vip = vip;
    }

    //Getter and Setter
    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    //Metodos
    public String toString(){
        return super.toString() + "VIP: " + this.vip;
    }

    @Override
    public void register(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre: ");
        this.setName(scanner.nextLine());
        System.out.println("Apellido: ");
        this.setSurname(scanner.nextLine());
        System.out.println("Género: ");
        this.setGender(scanner.nextLine());;
        System.out.println("País de Origen: ");
        this.setOrigin(scanner.nextLine());;
        System.out.println("Dirección: ");
        this.setAddress(scanner.nextLine());;
        System.out.println("Contraseña: ");
        this.setPassword(scanner.nextLine());;
        System.out.println("E-Mail: ");
        this.setEmailAddress(scanner.nextLine());
        System.out.println("Nombre de usuario: ");
        this.setUserName(scanner.nextLine());
    }
}
