package org.example.controller.auth;

import org.example.model.User;

public class RegistrationService {

    private final UsersManagement usersManagement;

    public RegistrationService() {
        this.usersManagement = UsersManagement.getInstance();
    }

    public RegistrationService(UsersManagement usersManagement) {
        this.usersManagement = usersManagement;
    }

    public RegistrationService(AuthService authService) {
        this.usersManagement = new UsersManagement();
    }

    public void registerUser(User user) {
        if(user == null) return;
        // Validation missing
        usersManagement.addUser(user);
    }
}
