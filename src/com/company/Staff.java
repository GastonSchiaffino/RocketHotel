package com.company;

public class Staff {
    ///Atributos
    private boolean permissionUser;
    private double salary;
    private int antiquity;

    ///Constructores
    public Staff(){
    }

    public Staff(boolean permissionUser, double salary, int antiquity) {
        this.permissionUser = permissionUser;
        this.salary = salary;
        this.antiquity = antiquity;
    }
}
