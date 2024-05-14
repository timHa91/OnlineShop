package org.example.models;

public interface Credentials {

    void setEmail(String email);
    void setPassword(String newPassword);

    String getEmail();
    String getPassword();
}
