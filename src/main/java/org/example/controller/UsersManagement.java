package org.example.controller;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersManagement {

    private static UsersManagement instance;
    private final List<User> users;

    private UsersManagement() {
        this.users = new ArrayList<>();
    }

    public static synchronized UsersManagement getInstance() {
        if (instance == null) {
            instance = new UsersManagement();
        }
        return instance;
    }
    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if(user != null) {
            this.users.add(user);
        }
    }
}
