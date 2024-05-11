package org.example.controller;

import org.example.controller.auth.RegistrationService;
import org.example.controller.auth.UsersManagement;
import org.example.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistrationServiceTest {

    private RegistrationService registrationService;
    private UsersManagement usersManagement;

    @BeforeEach
    void setUp() {
        usersManagement = new UsersManagement();
        registrationService = new RegistrationService(usersManagement);
    }

    @Test
    void testRegisterUser_WhenUserIsValid() {
        registrationService.registerUser(new User("test@test", "123456"));
        Assertions.assertEquals(1, usersManagement.getUsers().size());
    }
}