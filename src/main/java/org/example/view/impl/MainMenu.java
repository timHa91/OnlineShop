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
        while(true) {
            if (applicationContext.getMainMenu() == null) {
                applicationContext.setMainMenu(this);
            }
            Menu menuToNavigate;
            mainLoop: while(true) {
                Scanner scanner = new Scanner(System.in);
                this.printMenuHeader();

                System.out.println("User input: ");
                String userInput = scanner.next();

                if (userInput.equalsIgnoreCase(EXIT_COMMAND)) {
                    System.out.println("Bye!");
                    System.exit(0);
                } else {
                    int commandNumber = Integer.parseInt(userInput);
                    switch(commandNumber) {
                        case 1:
                            menuToNavigate = new SignUpMenu();
                            break mainLoop;
                        case 2:
                            menuToNavigate = (applicationContext.getLoggedInUser() != null) ? new SignOutMenu() : new SignInMenu();
                            break mainLoop;
                        case 3:
                            menuToNavigate = new ProductCatalogMenu();
                            break mainLoop;
                        case 4:
                            menuToNavigate = new MyOrdersMenu();
                            break mainLoop;
                        case 5:
                            menuToNavigate = new SettingsMenu();
                            break mainLoop;
                        case 6:
                            menuToNavigate = new CustomerListMenu();
                            break mainLoop;
                        default:
                            System.out.println("Error: Only 1, 2, 3, 4, 5, 6 is allowed. Try one more time.");
                    }
                }
            }
            menuToNavigate.start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** MAIN MENU *****");
        System.out.println(
                "1. Sign Up\n" +
                        "2. " + ((applicationContext.getLoggedInUser() != null) ? "Sign Out" : "Sign In") + "\n" +
                        "3. Product Catalog\n" +
                        "4. My Orders\n" +
                        "5. Settings\n" +
                        "6. Customer List");
    }
}
