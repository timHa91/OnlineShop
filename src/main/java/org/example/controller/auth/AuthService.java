package org.example.controller.auth;

import org.example.model.User;

import java.util.List;

public class AuthService {
    private final UsersManagement usersManagement;
    private boolean isAuthenticated;

    public AuthService(UsersManagement usersManagement) {
        this.usersManagement = usersManagement;
        this.isAuthenticated = false;
    }

    public AuthService() {
        this.usersManagement = UsersManagement.getInstance();
        this.isAuthenticated = false;
    }

    public boolean authenticateUser(User userCredentials) {
        if (userCredentials == null || usersManagement.getUsers() == null) return false;

        List<User> users = usersManagement.getUsers();
        isAuthenticated = users.stream().anyMatch(foundUser -> foundUser.equals(userCredentials));
        return isAuthenticated;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}
