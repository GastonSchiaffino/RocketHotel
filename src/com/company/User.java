package com.company;

import java.util.Scanner;

public class User {
    ///Atributos
    private String name;
    private String surname;
    private String dni;
    private String gender;
    private String origin;
    private String address;
    private String userName;
    private String password;
    private String emailAddress;

    ///Constructores
    public User(){
    }

    public User(String name,String surname,String dni,String gender,String origin,String address,String userName,String password,String emailAddress) {
      this.name=name;
      this.surname=surname;
      this.dni=dni;
      this.gender=gender;
      this.origin=origin;
      this.address=address;
      this.userName=userName;
      this.password=password;
      this.emailAddress=emailAddress;
    }

    ///Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    ///Metodos

    public void register(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre: ");
        this.name = scanner.nextLine();
        System.out.println("Apellido: ");
        this.surname = scanner.nextLine();
        System.out.println("DNI: ");
        this.dni = scanner.nextLine();
        System.out.println("Género: ");
        this.gender = scanner.nextLine();
        System.out.println("País de Origen: ");
        this.origin = scanner.nextLine();
        System.out.println("Dirección: ");
        this.address = scanner.nextLine();
        System.out.println("Nombre de usuario: ");
        this.userName = scanner.nextLine();
        System.out.println("Contraseña: ");
        this.password = scanner.nextLine();
        System.out.println("E-Mail: ");
        this.emailAddress = scanner.nextLine();
    }
    @Override
    public String toString(){
        return "Datos de usuario: " + "\n Nombre: " + this.name + "\n Apellido: " + this. surname +
                "\n Dni: " +this.dni + "\n Género: " +this. gender + "\n País de Origen: " + this.origin +
                "\n Dirección : " + this.address + "\n Nombre de usuario : " + this.userName +
                "\n Contraseña : " + this.password + "\n E-Mail : " + this.emailAddress;
    }
}
