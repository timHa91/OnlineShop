package org.example.services.impl;

import org.example.configs.ApplicationContext;
import org.example.models.Credentials;
import org.example.models.User;
import org.example.services.UserManagementService;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class UsersManagementServiceImpl implements UserManagementService {

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";

    private static final String SIGNUP_FAILED_MESSAGE = "Unfortunately, such login and password doesn’t exist";

    private static final String NO_ERROR_MESSAGE = "";

    private static final int DEFAULT_USERS_CAPACITY = 10;

    private static UsersManagementServiceImpl instance;
    private final ApplicationContext applicationContext;
    private int lastUserIndex;

    private User[] users;

    private UsersManagementServiceImpl() {
        users = new User[DEFAULT_USERS_CAPACITY];
        this.applicationContext = ApplicationContext.getInstance();
        this.lastUserIndex = -1;
    }

    public static UsersManagementServiceImpl getInstance() {
        if (instance == null) {
            instance = new UsersManagementServiceImpl();
        }
        return instance;
    }

    @Override
    public User[] getUsers() {
        return Arrays.stream(users)
                .filter(Objects::nonNull)
                .toArray(User[]::new);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        if (userEmail != null && !userEmail.isEmpty() && users != null) {
            return Arrays.stream(users)
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
        // Check Users Array Capacity
        if(this.users.length <= lastUserIndex) {
            doubleArrayCapacity();
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
            lastUserIndex++;
            this.users[user.getId() - 1] = user;
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

    private void doubleArrayCapacity() {
        this.users = Arrays.copyOf(this.users, users.length << 1);
    }

    void clearServiceState() {
        lastUserIndex = 0;
        users = new User[DEFAULT_USERS_CAPACITY];
    }
}
