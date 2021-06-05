package com.company;

import java.util.ArrayList;
import java.util.List;

public class CollectionUser {
    ///Atributos
    private List<User> collectionUser = new ArrayList<>();

    ///Constructores
    public CollectionUser() {
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
    public User loginUser(String userName, String password) {
        User user = new User();

        for (User x : collectionUser) {
            if (userName.equals(x.getUserName()) || userName.equals(x.getEmailAddress())) {
                if (password.equals(x.getPassword())) {
                    user = x;
                }
            }
        }
        return user;
    }

    public User searchUser(String dni) {
        Client client;
        Receptionist receptionist;
        Administrator administrator;

        for (User x : getCollectionUser()) {
            if (x.getDni().equals(dni)) {
                if (getCollectionUser() instanceof Client) {
                    client = (Client) x;
                    return client;
                } else if (getCollectionUser() instanceof Administrator) {
                    administrator = (Administrator) x;
                    return administrator;
                } else {
                    receptionist = (Receptionist) x;
                    return receptionist;
                }
            }
        }
        return null;
    }



}
