package org.example.services.impl;

import org.example.models.Credentials;
import org.example.models.User;
import org.example.models.impl.CredentialsImpl;
import org.example.models.impl.UserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsersManagementServiceImplTest {

    private UsersManagementServiceImpl userService;

    @BeforeEach
    public void setUp() {
        userService = UsersManagementServiceImpl.getInstance();
        userService.clearServiceState();
    }

    @Test
    public void testRegisterUser_UniqueEmail() {
        User newUser = new UserImpl("Tim", "Test", "newuser@example.com", "password");
        assertEquals("", userService.registerUser(newUser));
        assertEquals(newUser, userService.getUserByEmail("newuser@example.com"));
    }

    @Test
    public void testRegisterUser_DuplicateEmail() {
        User existingUser = new UserImpl("Tom", "Test", "existinguser@example.com", "password");
        userService.registerUser(existingUser);

        User duplicateUser = new UserImpl("Tom","Test", "existinguser@example.com", "password");
        assertEquals("This email is already used by another user. Please, use another email", userService.registerUser(duplicateUser));
    }

    @Test
    public void testRegisterUser_NullUser() {
        assertThrows(NullPointerException.class, () -> userService.registerUser(null));
    }

    @Test
    public void testAuthenticateUser_ValidCredentials() {
        User existingUser = new UserImpl("Tolgay", "Test", "user@example.com", "password");
        userService.registerUser(existingUser);

        Credentials validCredentials = new CredentialsImpl("user@example.com", "password");
        assertEquals("", userService.authenticateUser(validCredentials));
    }

    @Test
    public void testAuthenticateUser_InvalidCredentials() {
        User existingUser = new UserImpl("Eda","Test", "user@example.com", "password");
        userService.registerUser(existingUser);

        Credentials invalidCredentials = new CredentialsImpl("user@example.com", "wrongpassword");
        assertEquals("Unfortunately, such login and password doesn’t exist", userService.authenticateUser(invalidCredentials));
    }

    @Test
    public void testAuthenticateUser_NullCredentials() {
        assertEquals("Unfortunately, such login and password doesn’t exist", userService.authenticateUser(null));
    }

    @Test
    public void testGetUserByEmail_ExistingEmail() {
        User existingUser = new UserImpl("Tuti","Test", "user@example.com", "password");
        userService.registerUser(existingUser);

        assertNotNull(userService.getUserByEmail("user@example.com"));
    }

    @Test
    public void testGetUserByEmail_NonExistingEmail() {
        assertNull(userService.getUserByEmail("nonexisting@example.com"));
    }

    @Test
    public void testGetUsers_Empty() {
        assertEquals(0, userService.getUsers().length);
    }

    @Test
    public void testGetUsers_NonEmpty() {
        User user1 = new UserImpl("Test1","Test", "user1@example.com", "password1");
        User user2 = new UserImpl("Test2","Test", "user2@example.com", "password2");
        userService.registerUser(user1);
        userService.registerUser(user2);

        assertEquals(2, userService.getUsers().length);
    }

}
