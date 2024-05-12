package org.example.models.impl;

import org.example.models.Credentials;

public class CredentialsImpl implements Credentials {

    private String email;
    private String password;
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
