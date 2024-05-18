package org.example.services;

import org.example.models.Credentials;
import org.example.models.User;

import java.util.List;

public interface UserManagementService {

    String registerUser(User user);

    String authenticateUser(Credentials credentials);

    List<User> getUsers();

    User getUserByEmail(String userEmail);

}

