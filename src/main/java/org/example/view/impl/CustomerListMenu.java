package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.models.User;
import org.example.services.UserManagementService;
import org.example.services.impl.UsersManagementServiceImpl;
import org.example.view.Menu;

public class CustomerListMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = UsersManagementServiceImpl.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        User[] users = userManagementService.getUsers();

        if (users.length == 0) {
            System.out.println("Unfortunately, there are no customers.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");
    }
}
