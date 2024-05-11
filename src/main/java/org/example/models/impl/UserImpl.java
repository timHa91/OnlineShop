package org.example.models.impl;

import org.example.models.User;

public class UserImpl implements User {

    private static int userCreatedCount;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserImpl(String firstName, String lastName, String email, String password) {
        userCreatedCount++;
        this.id = userCreatedCount + 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
}
