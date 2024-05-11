package org.example.view;

import org.example.controller.auth.AuthService;
import org.example.controller.validation.InputValidator;

import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner;
    private final AuthService authService;

    public MainMenu(Scanner scanner, AuthService authService) {
        this.scanner = scanner;
        this.authService = authService;
    }

    public void runMainMenu() {
        this.printMainMenu();
        boolean isRunning = true;
        while(isRunning) {
            String userInput = getUserInput();
            switch(userInput) {
                case "1":
                    System.out.println("Sign Up");
                    break;
                case "2":
                    System.out.println(authService.isAuthenticated() ? "Sign Out" : "Sign In");
                    break;
                case "3":
                    System.out.println("Product Catalog");
                    break;
                case "4":
                    System.out.println("My Orders");
                    break;
                case "5":
                    System.out.println("Settings");
                    break;
                case "6":
                    System.out.println("Customer List");
                    break;
                case "exit":
                    System.out.println("Bye!");
                    isRunning = false;
                    break;
            }
        }
    }

    private void printMainMenu() {
        System.out.println(
                "1. Sign Up\n" +
                        "2. " + (authService.isAuthenticated() ? "Sign Out" : "Sign In") + "\n" +
                        "3. Product Catalog\n" +
                        "4. My Orders\n" +
                        "5. Settings\n" +
                        "6. Customer List");
    }

    private String getUserInput() {
        String userInput = null;
        boolean inputIsValid = false;
        while(!inputIsValid) {
            userInput = scanner.next();
           inputIsValid = InputValidator.validateMainMenuInput(userInput);
        }
        return userInput;
    }
}
