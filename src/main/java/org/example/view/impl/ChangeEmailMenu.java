package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.view.Menu;

import java.util.Scanner;

public class ChangeEmailMenu implements Menu {

    private final String EMAIL_CHANGED_SUCCESS = "Your email has been successfully changed";
    private final ApplicationContext applicationContext;

    {
        applicationContext = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner scanner = new Scanner(System.in);
        String newEmail = scanner.next();
        if (newEmail != null && !newEmail.isEmpty()) {
            applicationContext.getLoggedInUser().setEmail(newEmail);
            System.out.println(EMAIL_CHANGED_SUCCESS);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHANGE PASSWORD *****");
        System.out.println("Please enter a new Email:");
    }
}
