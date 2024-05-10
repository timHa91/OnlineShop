package org.example.control;

import org.example.model.User;

import java.util.List;

public class UsersManagement {

    private List<User> users;

    public UsersManagement(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if(user != null) {
            this.users.add(user);
        }
    }

    public class AuthService {
        private static boolean isAuthenticated;

        public void authenticateUser(User userCredentials) {

            if(userCredentials == null || isAuthenticated || users == null) return;

            boolean userAuthenticated = users.stream()
                    .anyMatch(foundUser -> foundUser.equals(userCredentials));

            isAuthenticated = userAuthenticated ? true : false;
        }

        public boolean getAuthenticationState() {
            return isAuthenticated;
        }
    }
}
