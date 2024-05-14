package org.example.models.impl;

import org.example.models.Credentials;

public class CredentialsImpl implements Credentials {

    private String email;
    private String password;

    public CredentialsImpl(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
