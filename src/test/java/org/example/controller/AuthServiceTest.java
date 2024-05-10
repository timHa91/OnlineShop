package org.example.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    public void setUp() {
        authService = new AuthService();
        UsersManagement.getInstance().addUser(new User("alice", "password123"));
        UsersManagement.getInstance().addUser(new User("bob", "pass456"));
    }

    @Test
    public void testAuthenticateUser_WhenUserCredentialsIsNull() {
        authService.authenticateUser(null);
        assertFalse(authService.getAuthenticationState());
    }

    @Test
    public void testAuthenticateUser_WithInvalidCredentials() {
        authService.authenticateUser(new User("username", "password"));
        assertFalse(authService.getAuthenticationState());
    }

    @Test
    public void testAuthenticateUser_WithValidCredentials() {
        authService.authenticateUser(new User("alice", "password123"));
        assertTrue(authService.getAuthenticationState());
    }
}
