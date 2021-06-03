package com.company;

public class Administrator extends Staff{
    ///Atributos

    ///Constructores
    public Administrator(){
    }

    public Administrator(String name, String surname, String dni, String gender, String origin, String address, String userName, String password, String emailAddress, boolean permissionUser, double salary, int antiquity) {
        super(name, surname, dni, gender, origin, address, userName, password, emailAddress, permissionUser, salary, antiquity);
    }

    ///Metodos
}
