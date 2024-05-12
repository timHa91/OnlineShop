package org.example.view.impl;

import org.example.view.Menu;

import java.util.Scanner;

public class SignInMenu implements Menu {



    @Override
    public void start() {
        printMenuHeader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your email: ");
        String email = scanner.next();
        System.out.println("Please, enter your password: ");
        String password = scanner.next();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN IN *****");
    }
}
