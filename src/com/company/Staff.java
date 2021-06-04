package com.company;

public class Staff extends User{
    ///Atributos
    private boolean permissionUser;
    private double salary;
    private int antiquity;

    ///Constructores
    public Staff(){
        super();
    }

    public Staff(String name, String surname, String dni, String gender, String origin, String address, String userName, String password, String emailAddress, boolean permissionUser, double salary, int antiquity) {
        super(name, surname, dni, gender, origin, address, userName, password, emailAddress);
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
    public Client searchClient(String dni, CollectionUser users){
        Client client= new Client();
        for (User x: users.collectionUser) {
            if(users.collectionUser instanceof Client){
                if (x.getDni().equals(dni)){
                    client= (Client)x;
                }
            }
        }
        return client;
    }
}
