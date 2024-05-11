package org.example.view.impl;

import org.example.services.impl.UsersManagementServiceImpl;
import org.example.services.InputValidatorService;
import org.example.models.User;
import org.example.models.impl.UserImpl;
import org.example.view.Menu;

import java.util.Scanner;

public class MainMenu implements Menu {

    private final Scanner scanner;
    private final UsersManagementServiceImpl usersManagementServiceImpl;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
        this.usersManagementServiceImpl = UsersManagementServiceImpl.getInstance();
    }

    @Override
    public void start() {
        boolean isRunning = true;
        while(isRunning) {
            this.printMenuHeader();
            String userInput = getUserInput();
            switch(userInput) {
                case "1":
                    usersManagementServiceImpl.registerUser(registerPrompt());
                    break;
                case "2":

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

    @Override
    public void printMenuHeader() {
        System.out.println(
                "1. Sign Up\n" +
                        "2. " + (UsersManagementServiceImpl.isAuthenticated ? "Sign Out" : "Sign In") + "\n" +
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
           inputIsValid = InputValidatorService.validateMainMenuInput(userInput);
        }
        return userInput;
    }

    private User registerPrompt() {
        System.out.println("Enter First Name:");
        String firstname = scanner.next();
        System.out.println("Enter Last Name:");
        String lastname = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        System.out.println("Enter email:");
        String email = scanner.next();

        return new UserImpl(
                email,
                password,
                firstname,
                lastname
        );
    }
}
