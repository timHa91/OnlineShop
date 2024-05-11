package org.example.services;

import org.example.models.User;

import java.util.List;

public interface UserManagementService {

    String registerUser(User user);

    List<User> getUsers();

    User getUserByEmail(String userEmail);

}

