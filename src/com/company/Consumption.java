package com.company;

import java.util.Objects;

public class Consumption {
    ///Atributos
    private int idConsumption;
    private double price;
    private String description;

    ///Constructores
    public Consumption(){
    }
    public Consumption(int idConsumption,double price,String description){
        this.description=description;
        this.idConsumption=idConsumption;
        this.price=price;
    }

///Getters and Setters
    public int getIdConsumption() {
        return idConsumption;
    }

    public void setIdConsumption(int idConsumption) {
        this.idConsumption = idConsumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    ///Equal and Hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumption that = (Consumption) o;
        return idConsumption == that.idConsumption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConsumption);
    }

    ///Metodos
    @Override
    public String toString(){
        return this.idConsumption + ".  " + this.idConsumption + "  " + this.price;
    }
}
