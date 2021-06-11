package com.company;

import java.util.Scanner;

public class Receptionist extends Staff{
    ///Atributos

    ///Constructores
    public Receptionist(){
    }

    public Receptionist(String name, String surname, String dni, String gender, String origin, String address, String userName, String password, String emailAddress, boolean permissionUser, double salary, int antiquity) {
        super(name, surname, dni, gender, origin, address, userName, password, emailAddress, permissionUser, salary, antiquity);
    }

    ///Metodos
    @Override
    public void register(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre: ");
        this.setName(scanner.nextLine());
        System.out.println("Apellido: ");
        this.setSurname(scanner.nextLine());
        System.out.println("DNI: ");
        this.setDni(scanner.nextLine());
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
        System.out.println("Permiso de usuario: ");
        this.setPermissionUser(false);
        System.out.println("Salario: ");
        this.setSalary(scanner.nextDouble());
        System.out.println("Antiguedad: ");
        this.setAntiquity(scanner.nextInt());
    }

    @Override
    public void calculatedSalary(int horas){
         this.setSalary(horas * 250 * 30);
    }
}
