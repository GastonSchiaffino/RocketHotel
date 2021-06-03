package com.company;

public class Receptionist extends Staff{
    ///Atributos
    private String colorUniform;

    ///Constructores
    public Receptionist(){
    }

    public Receptionist(String name, String surname, String dni, String gender, String origin, String address, String userName, String password, String emailAddress, boolean permissionUser, double salary, int antiquity, String colorUniform) {
        super(name, surname, dni, gender, origin, address, userName, password, emailAddress, permissionUser, salary, antiquity);
        this.colorUniform = colorUniform;
    }

    ///Getter and Setter
    public String getColorUniform() {
        return colorUniform;
    }

    public void setColorUniform(String colorUniform) {
        this.colorUniform = colorUniform;
    }

    ///Metodos
}
