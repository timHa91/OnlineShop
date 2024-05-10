package org.example.controller;

import org.example.model.User;

public class AuthService {

    private final UsersManagement usersManagement = UsersManagement.getInstance();

    private static boolean isAuthenticated;

   public void authenticateUser(User userCredentials) {
       if(userCredentials == null || usersManagement.getUsers() == null) return;

       isAuthenticated = usersManagement.getUsers().stream()
                    .anyMatch(foundUser -> foundUser.equals(userCredentials));
        }
        public boolean getAuthenticationState() {
            return isAuthenticated;
        }
}
