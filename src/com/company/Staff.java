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

    ///Getter and Setter
    public boolean isPermissionUser() {
        return permissionUser;
    }

    public void setPermissionUser(boolean permissionUser) {
        this.permissionUser = permissionUser;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }

    ///Metodos
}
