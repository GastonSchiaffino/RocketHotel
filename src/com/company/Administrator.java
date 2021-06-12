package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Administrator extends Staff{
    ///Atributos

    ///Constructores
    public Administrator(){
    }

    public Administrator(String name, String surname, String dni, String gender, String origin, String address, String userName, String password, String emailAddress, boolean permissionUser, double salary, int antiquity) {
        super(name, surname, dni, gender, origin, address, userName, password, emailAddress, permissionUser, salary, antiquity);
    }

    ///Metodos
    @Override
    public void register(){
        Scanner scanner = new Scanner(System.in);
        int hours;
        String day;

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
        //System.out.println("Permiso de usuario: ");
        this.setPermissionUser(true);
        System.out.println("Horas de trabajo por dia: ");
        hours= scanner.nextInt();
        calculatedSalary(hours);
        System.out.println("Salario: " + this.getSalary());
        System.out.println("Fecha de ingreso del empleado(formato: xx/xx/xxxx): ");
        day= scanner.next();
        this.setAntiquity(calculatedAntiquity(day));
        System.out.println("Antiguedad: " + this.getAntiquity());
    }

    @Override
    public void calculatedSalary(int horas){
        this.setSalary(horas * 400 * 30);
    }

    public void fileToBackup(File file, File backup){
        try {
            Path fountain = Paths.get(file.getPath());
            Path destiny = Paths.get(backup.getPath());
            Files.copy(fountain, destiny, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("\nError al realizar la copia de datos.");
        }
    }
}
