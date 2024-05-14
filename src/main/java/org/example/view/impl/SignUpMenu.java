package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.models.impl.UserImpl;
import org.example.services.impl.UsersManagementServiceImpl;
import org.example.view.Menu;

import java.util.Scanner;

public class SignUpMenu implements Menu {

    private final UsersManagementServiceImpl usersManagementService;
    private final ApplicationContext applicationContext;

    {
        usersManagementService = UsersManagementServiceImpl.getInstance();
        applicationContext = ApplicationContext.getInstance();
    }


    @Override
    public void start() {
        printMenuHeader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String firstname = scanner.next();
        System.out.println("Enter Last Name:");
        String lastname = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        System.out.println("Enter email:");

        scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        UserImpl newUser = new UserImpl(
                firstname,
                lastname,
                email,
                password
        );

        String errorMessage = usersManagementService.registerUser(newUser);

        if (errorMessage == null || errorMessage.isEmpty()) {
            applicationContext.setLoggedInUser(newUser);
            System.out.println("New user is created");
        } else {
            System.out.println(errorMessage);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN UP *****");
    }
}
