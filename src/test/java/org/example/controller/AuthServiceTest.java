package org.example.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.example.controller.auth.AuthService;
import org.example.controller.auth.UsersManagement;
import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    public void setUp() {
        // Erstellen einer neuen Instanz von UsersManagement für die Tests
        UsersManagement testUsersManagement = new UsersManagement();
        authService = new AuthService(testUsersManagement);
        // Fügen Sie Testbenutzer zur testUsersManagement-Instanz hinzu
        testUsersManagement.addUser(new User("testuser", "testpassword"));
        testUsersManagement.addUser(new User("alice", "password123"));
    }

    @Test
    public void testAuthenticateUser_WhenUserCredentialsIsNull() {
        assertFalse(authService.authenticateUser(null));
    }

    @Test
    public void testAuthenticateUser_WithInvalidCredentials() {
        assertFalse(authService.authenticateUser(new User("username", "password")));
    }

    @Test
    public void testAuthenticateUser_WithValidCredentials() {
        assertTrue(authService.authenticateUser(new User("alice", "password123")));
    }
}
