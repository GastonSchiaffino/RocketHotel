package com.company;

import java.util.ArrayList;
import java.util.List;

public class CollectionConsumption {
    ///Atributos
    List<Consumption> listConsumption = new ArrayList<>();


    ///Constructores
    public CollectionConsumption(){
    }
    public CollectionConsumption(List<Consumption> listConsumption){
        this.listConsumption=listConsumption;
    }

    ///Getter and Setter

    public List<Consumption> getListConsumption() {
        return listConsumption;
    }

    public void setListConsumption(List<Consumption> listConsumption) {
        this.listConsumption = listConsumption;
    }

    ///Metodos

    public void loadConsumption(){
        ///BEBIDAS
        Consumption consumption1 = new Consumption(1,150.00, "Cafe"); Consumption consumption2 = new Consumption(2,90.00, "Te");
        Consumption consumption3 = new Consumption(3,130.00, "Licuado"); Consumption consumption4 = new Consumption(4,200.00, "MilkShake");
        Consumption consumption5 = new Consumption(5,80.00, "Gaseosa"); Consumption consumption6 = new Consumption(6,100.00, "Cerveza");
        Consumption consumption7 = new Consumption(7,450.00, "Whisky"); Consumption consumption8 = new Consumption(8,300.00, "Ron");
        Consumption consumption9 = new Consumption(9,350.00, "Champagne");Consumption consumption10 = new Consumption(10,250.00, "Vino");
        Consumption consumption11 = new Consumption(11,300.00, "Licor");
        ///COMIDAS
        Consumption consumption12 = new Consumption(12,120.00, "Tostado"); Consumption consumption13 = new Consumption(13,70.00, "Croissant");
        Consumption consumption14 = new Consumption(14,35.00, "Donas"); Consumption consumption15 = new Consumption(15,75.00, "Omelette");
        Consumption consumption16 = new Consumption(16,350.00, "Milanesa Napolitana con Papas Fritas"); Consumption consumption17 = new Consumption(17,450.00, "Bife con pure");
        Consumption consumption18 = new Consumption(18,300.00, "Spaghetti a la bolognesa"); Consumption consumption19 = new Consumption(19,325.00, "Wook de verduras");

        listConsumption.add(consumption1); listConsumption.add(consumption2); listConsumption.add(consumption3); listConsumption.add(consumption4);
        listConsumption.add(consumption5); listConsumption.add(consumption6); listConsumption.add(consumption7); listConsumption.add(consumption8);
        listConsumption.add(consumption9); listConsumption.add(consumption10); listConsumption.add(consumption11); listConsumption.add(consumption12);
        listConsumption.add(consumption13); listConsumption.add(consumption14); listConsumption.add(consumption15); listConsumption.add(consumption16);
        listConsumption.add(consumption17); listConsumption.add(consumption18); listConsumption.add(consumption19);

    }

    public void addConsumption(Consumption consumption){
        listConsumption.add(consumption);
    }
    public void removeConsumption(Consumption consumption){
        listConsumption.remove(consumption);
    }

    public Consumption searchConsumption(int id){
        Consumption consumption= new Consumption();
        for (Consumption x: listConsumption) {
            if (x.getIdConsumption()==(id)){
                consumption= x;
            }
        }
        return consumption;
    }


    public void modifyPriceConsumption(int id, double price) {
        for (Consumption x : listConsumption) {
            if (x.getIdConsumption() == (id)) {
                x.setPrice(price);
            }
        }
    }
}
