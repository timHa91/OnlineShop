package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.view.Menu;

import java.util.Scanner;

public class SettingsMenu implements Menu {
    private final String USER_INPUT_ERROR = "Only 1, 2 is allowed. Try one more time";
    private final String NOT_LOGGED_IN_ERROR = "Please, log in or create new account to change your account settings";

    private final ApplicationContext applicationContext;

    {
        applicationContext = ApplicationContext.getInstance();
    }
    @Override
    public void start() {
        if (applicationContext.getLoggedInUser() == null) {
            System.out.println(NOT_LOGGED_IN_ERROR);
            return;
        }

        Menu menuToNavigate;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            printMenuHeader();
            String userInput = scanner.next();

            if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
                menuToNavigate = applicationContext.getMainMenu();
                break;
            }

            switch (userInput) {
                case "1":
                    menuToNavigate = new ChangePasswordMenu();
                    break;
                case "2":
                    menuToNavigate = new ChangeEmailMenu();
                    break;
                case MainMenu.EXIT_COMMAND:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println(USER_INPUT_ERROR);
                    continue;
            }

            if (menuToNavigate != null) {
                break;
            }
        }
        menuToNavigate.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SETTINGS *****");
        System.out.println(
                "1. Change Password \n" +
                "2. Change Email"
                );
    }


}
