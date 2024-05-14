package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.view.Menu;

public class SignOutMenu implements Menu {

    private final ApplicationContext applicationContext;

    {
        applicationContext = ApplicationContext.getInstance();
    }
    @Override
    public void start() {
        printMenuHeader();
        applicationContext.setLoggedInUser(null);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("Have a nice day! Look forward to welcoming back");
    }
}
