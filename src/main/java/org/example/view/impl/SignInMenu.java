package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.models.impl.CredentialsImpl;
import org.example.services.impl.UsersManagementServiceImpl;
import org.example.view.Menu;

import java.util.Scanner;

public class SignInMenu implements Menu {

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
        System.out.println("Please, enter your email: ");
        String email = scanner.next();
        System.out.println("Please, enter your password: ");
        String password = scanner.next();
        String errorMessage = usersManagementService.authenticateUser(new CredentialsImpl(
                email,
                password
        ));
        if (errorMessage == null && errorMessage.isEmpty()) {
            System.out.printf("Glad to see you back, %s %s",
                    applicationContext.getLoggedInUser().getFirstName(),
                    applicationContext.getLoggedInUser().getLastName()
                    );
        } else {
            System.out.println(errorMessage);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN IN *****");
    }
}
