package org.example.services;

import org.example.models.Credentials;
import org.example.models.User;

public interface UserManagementService {

    String registerUser(User user);

    String authenticateUser(Credentials credentials);

    User[] getUsers();

    User getUserByEmail(String userEmail);

}

