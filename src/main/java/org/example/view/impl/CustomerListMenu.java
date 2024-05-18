package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.models.User;
import org.example.services.UserManagementService;
import org.example.services.impl.UsersManagementServiceImpl;
import org.example.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class CustomerListMenu implements Menu {


    private final UserManagementService userManagementService;

    {
        userManagementService = UsersManagementServiceImpl.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        List<User> users = userManagementService.getUsers();

        if (users.isEmpty()) {
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
