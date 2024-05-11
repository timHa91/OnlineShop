package org.example.services.impl;

import org.example.models.User;
import org.example.services.UserManagementService;

import java.util.ArrayList;
import java.util.List;

public class UsersManagementServiceImpl implements UserManagementService {

    private static UsersManagementServiceImpl instance;
    private final List<User> users;
    public static boolean isAuthenticated;

    public UsersManagementServiceImpl() {
        this.users = new ArrayList<>();
    }

    public static synchronized UsersManagementServiceImpl getInstance() {
        if (instance == null) {
            instance = new UsersManagementServiceImpl();
        }
        return instance;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return null;
    }

    @Override
    public String registerUser(User user) {
        this.addUser(user);
        isAuthenticated = true;
        return "New user is created";
    }

    private void addUser(User user) {
        if(user != null) {
            this.users.add(user);
        }
    }

    public boolean authenticateUser(User userCredentials) {
        if (userCredentials == null) return false;
        isAuthenticated = users.stream().anyMatch(foundUser -> foundUser.equals(userCredentials));
        return isAuthenticated;
    }
}
