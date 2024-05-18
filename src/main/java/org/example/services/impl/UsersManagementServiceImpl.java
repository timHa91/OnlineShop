package org.example.services.impl;

import org.example.configs.ApplicationContext;
import org.example.models.Credentials;
import org.example.models.User;
import org.example.services.UserManagementService;

import java.util.*;

public class UsersManagementServiceImpl implements UserManagementService {

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";

    private static final String SIGNUP_FAILED_MESSAGE = "Unfortunately, such login and password doesn’t exist";

    private static final String NO_ERROR_MESSAGE = "";

    private static UsersManagementServiceImpl instance;
    private final ApplicationContext applicationContext;

    private final List<User> users;

    {
        users = new ArrayList<>();
    }

    private UsersManagementServiceImpl() {
        this.applicationContext = ApplicationContext.getInstance();
    }

    public static UsersManagementServiceImpl getInstance() {
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
        if (userEmail != null && !userEmail.isEmpty() && users != null) {
            return users.stream()
                    .filter(user -> user != null && user.getEmail().equals(userEmail))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    @Override
    public String registerUser(User user) {
        Objects.requireNonNull(user, "User cannot be null");

        String errorMessage = checkIfEmailValid(user.getEmail());
        if (errorMessage != null && !errorMessage.isEmpty()) {
            return  errorMessage;
        }

        this.addUser(user);
        return NO_ERROR_MESSAGE;
    }

    @Override
    public String authenticateUser(Credentials credentials) {
        if (credentials != null) {
            User foundUser = getUserByEmail(credentials.getEmail());
            if(foundUser != null && foundUser.getPassword().equals(credentials.getPassword())) {
                applicationContext.setLoggedInUser(foundUser);
                return NO_ERROR_MESSAGE;
            }
        }
        return SIGNUP_FAILED_MESSAGE;
    }

    private void addUser(User user) {
        if(user != null) {
            this.users.add(user.getId() - 1, user);
        }
    }

    private String checkIfEmailValid(String email) {
        // Check if null or Empty
        if(email == null || email.isEmpty()) {
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }
        // Check if Unique
        for (User user : getUsers()) {
            if (user == null) continue;
            if (user.getEmail() != null && user.getEmail().equals(email)) {
                return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
            }
        }
        return NO_ERROR_MESSAGE;
    }

    void clearServiceState() {
        users.clear();
    }
}
