package com.example.shopcard.Model;

import java.security.PrivateKey;

public class UserModel {

    private String name;
    private String username ;
    private String password ;


    public UserModel(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
