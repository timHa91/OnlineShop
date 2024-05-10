package org.example.view;

import java.util.Scanner;

public class MainMenu {

    public void runMainMenu(Scanner scanner) {
        this.printMainMenu();
        boolean isRunning = true;
        while(isRunning) {
            String userInput = scanner.next();
            switch(userInput) {
                case "1":
                    System.out.println("Sign Up");
                    break;
                case "2":
                    System.out.println("Sign In / Sign Out");
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
                "2. Sign In / Sign Out\n" +
                "3. Product Catalog\n" +
                "4. My Orders\n" +
                "5. Settings\n" +
                "6. Customer List");
    }
}
