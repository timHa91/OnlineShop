package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.view.Menu;

import java.util.Scanner;

public class ChangePasswordMenu implements Menu {

    private final String PASSWORD_CHANGED_SUCCESS = "Your password has been successfully changed";
    private final ApplicationContext applicationContext;

    {
        applicationContext = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner scanner = new Scanner(System.in);
        String newPassword = scanner.next();
        if (newPassword != null && !newPassword.isEmpty()) {
            applicationContext.getLoggedInUser().setPassword(newPassword);
            System.out.println(PASSWORD_CHANGED_SUCCESS);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHANGE PASSWORD *****");
        System.out.println("Please enter a new Password:");
    }
}
