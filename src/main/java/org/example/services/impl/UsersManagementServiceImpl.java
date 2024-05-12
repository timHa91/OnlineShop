package org.example.services.impl;

import org.example.configs.ApplicationContext;
import org.example.models.Credentials;
import org.example.models.User;
import org.example.services.UserManagementService;

public class UsersManagementServiceImpl implements UserManagementService {

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";

    private static final int DEFAULT_USERS_CAPACITY = 10;

    private static UsersManagementServiceImpl instance;
    private final ApplicationContext applicationContext;

    private final User[] users;

    public UsersManagementServiceImpl() {
        users = new User[DEFAULT_USERS_CAPACITY];
        this.applicationContext = ApplicationContext.getInstance();
    }

    public static UsersManagementServiceImpl getInstance() {
        if (instance == null) {
            instance = new UsersManagementServiceImpl();
        }
        return instance;
    }

    @Override
    public User[] getUsers() {
        return users;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return null;
    }

    @Override
    public String registerUser(User user) {
        String errorMessage = checkIfEmailValid(user.getEmail());
        if (errorMessage != null && !errorMessage.isEmpty()) {
            return  errorMessage;
        }
        this.addUser(user);
        return NO_ERROR_MESSAGE;
    }

    @Override
    public String authenticateUser(Credentials credentials) {

        
        return null;
    }

    private void addUser(User user) {
        if(user != null) {
            this.users[user.getId() - 1] = user;
        }
    }

    private String checkIfEmailValid(String email) {
        System.out.println("Email: " + email);
        if(email == null || email.isEmpty()) {
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }

        for (User user : getUsers()) {
            if (user == null) continue;
            if (user.getEmail() != null && user.getEmail().equals(email)) {
                return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
            }
        }
        return NO_ERROR_MESSAGE;
    }
}
