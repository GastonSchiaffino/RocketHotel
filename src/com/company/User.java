package com.company;

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
}
