package org.example;

import org.example.controller.auth.AuthService;
import org.example.view.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(scanner, authService);
        mainMenu.runMainMenu();
    }
}