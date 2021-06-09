package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionUser {
    ///Atributos
    private List<User> listUser = new ArrayList<>();

    ///Constructores
    public CollectionUser(){
    }

    public CollectionUser(List<User> listUser) {
        this.listUser = listUser;
    }

    ///Getter and Setter
    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    ///Metodos
    public User loginUser(String userName, String password){
        User user= new User();
        user= null;

        for (User x: listUser) {
            if(userName.equals(x.getUserName()) || userName.equals(x.getEmailAddress())){
                if(password.equals(x.getPassword())) {
                    user= x;
                }
            }
        }

        return user;
    }

    public void addUser(User user){
        listUser.add(user);
    }

    public void removeUser(User user){
        listUser.remove(user);
    }

    public User searchUser(String dni){
        User user= null;
        for (User x: listUser) {
            if (x.getDni().equals(dni)){
                user= x;
            }
        }
        return user;
    }

    public Client searchClient(String dni){
        Client client= null;
        for (User x: listUser) {
            if(x instanceof Client) {
                if (x.getDni().equals(dni)) {
                    client= (Client) x;
                }
            }
        }
        return client;
    }

    public Administrator searchAdministrator(String dni){
        Administrator administrator= null;
        for (User x: listUser) {
            if(x instanceof Administrator) {
                if (x.getDni().equals(dni)) {
                    administrator= (Administrator) x;
                }
            }
        }
        return administrator;
    }

    public Receptionist searchReceptionist(String dni){
        Receptionist receptionist= null;
        for (User x: listUser) {
            if(x instanceof Receptionist) {
                if (x.getDni().equals(dni)) {
                    receptionist = (Receptionist) x;
                }
            }
        }
        return receptionist;
    }

    public User searchUserAsMail(String email){
        User user= null;
        for (User x: listUser) {
            if (x.getEmailAddress().equals(email)){
                user= x;
            }
        }
        return user;
    }

    public User searchUserAsUserName(String userName){
        User user= null;
        for (User x: listUser) {
            if (x.getUserName().equals(userName)){
                user= x;
            }
        }
        return user;
    }

    public void userModify(String dni){
        Scanner scanner = new Scanner(System.in);
        int opcion= 0;

        for (User x: listUser) {
            if(x.getDni().equals(dni)) {
                do {
                    System.out.println("Ingrese la opcion que desea modificar: \n");
                    System.out.println("1)Nombre.\n2)Apellido.\n3)DNI.\n4)Genero.\n5)Pais de origen.6)Direccion.\n7)Nombre de usuario.\n8)Constraseña.\n9)E-mail.\n\n0)Salir.\n\nOpcion: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1 -> {
                            System.out.println("Nombre: ");
                            x.setName(scanner.nextLine());
                        }
                        case 2 -> {
                            System.out.println("Apellido: ");
                            x.setSurname(scanner.nextLine());
                        }
                        case 3 -> {
                            System.out.println("DNI: ");
                            x.setDni(scanner.nextLine());
                        }
                        case 4 -> {
                            System.out.println("Género: ");
                            x.setGender(scanner.nextLine());
                        }
                        case 5 -> {
                            System.out.println("País de Origen: ");
                            x.setOrigin(scanner.nextLine());
                        }
                        case 6 -> {
                            System.out.println("Dirección: ");
                            x.setAddress(scanner.nextLine());
                        }
                        case 7 -> {
                            System.out.println("Nombre de usuario: ");
                            x.setUserName(scanner.nextLine());
                        }
                        case 8 -> {
                            System.out.println("Contraseña: ");
                            x.setPassword(scanner.nextLine());
                        }
                        case 9 -> {
                            System.out.println("E-Mail: ");
                            x.setEmailAddress(scanner.nextLine());
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

    public void showListClient(){
        for (User x:listUser) {
            if(x instanceof Client){
                System.out.println(x.toString());
            }
        }
    }

    public void showListAdministrator(){
        for (User x:listUser) {
            if(x instanceof Administrator){
                System.out.println(x.toString());
            }
        }
    }

    public void showListRecepcionist(){
        for (User x:listUser) {
            if(x instanceof Receptionist){
                System.out.println(x.toString());
            }
        }
    }

}
