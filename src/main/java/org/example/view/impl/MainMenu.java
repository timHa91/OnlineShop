package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.view.Menu;

import java.util.Scanner;

public class MainMenu implements Menu {
    public static final String EXIT_COMMAND = "exit";
    private final ApplicationContext applicationContext;

    {
        applicationContext = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        mainLoop: while(true) {
            this.printMenuHeader();

            switch(userInput) {
                case "1":
                    break mainLoop;
                case "2":

                    break mainLoop;
                case "3":
                    System.out.println("Product Catalog");
                    break mainLoop;
                case "4":
                    System.out.println("My Orders");
                    break mainLoop;
                case "5":
                    System.out.println("Settings");
                    break mainLoop;
                case "6":
                    System.out.println("Customer List");
                    break mainLoop;
                case "exit":
                    System.out.println("Bye!");
                    break mainLoop;
                default:
                    System.out.println("Error: Only 1, 2, 3, 4, 5, 6 is allowed. Try one more time.");
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println(
                "1. Sign Up\n" +
                        "2. " + ((applicationContext.getLoggedInUser() != null) ? "Sign Out" : "Sign In") + "\n" +
                        "3. Product Catalog\n" +
                        "4. My Orders\n" +
                        "5. Settings\n" +
                        "6. Customer List");
    }
}
