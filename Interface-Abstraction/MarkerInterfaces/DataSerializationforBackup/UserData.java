package com.gla.interfacesabstraction.MarkerInterfaces.DataSerializationforBackup;

import java.io.Serializable;

public class UserData implements Serializable {

    private String username;
    private String email;

    public UserData(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void display() {
        System.out.println("User: " + username + ", Email: " + email);
    }
}