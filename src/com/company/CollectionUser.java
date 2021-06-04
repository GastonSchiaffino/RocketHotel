package com.company;

import java.util.ArrayList;
import java.util.List;

public class CollectionUser {
    ///Atributos
    private List<User> collectionUser = new ArrayList<>();

    ///Constructores
    public CollectionUser(){
    }

    public CollectionUser(List<User> collectionUser) {
        this.collectionUser = collectionUser;
    }

    ///Getter and Setter

    public List<User> getCollectionUser() {
        return collectionUser;
    }

    public void setCollectionUser(List<User> collectionUser) {
        this.collectionUser = collectionUser;
    }

    ///Metodos

}
