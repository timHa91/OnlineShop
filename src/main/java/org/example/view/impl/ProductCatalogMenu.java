package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.models.Cart;
import org.example.models.Product;
import org.example.services.ProductManagementService;
import org.example.services.impl.ProductManagementServiceImpl;
import org.example.view.Menu;

import java.util.Arrays;
import java.util.Scanner;

public class ProductCatalogMenu implements Menu {

    private static final String USER_PROMPT = "Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu";
    private static final String ADD_PRODUCT_TO_CART_ERROR = "Please, enter product ID if you want to add product to cart. Or enter ‘checkout’ if you want to proceed with checkout. Or enter ‘menu’ if you want to navigate back to the main menu.";
    private static final String ADD_PRODUCT_TO_CART_SUCCESS = "Product %s has been added to your cart. If you want to add a new product - enter the product id. If you want to proceed with checkout - enter word ‘checkout’ to console\n";

    private static final String EMPTY_CART_ERROR = "Your cart is empty. Please, add product to cart first and then proceed with checkout";

    private static final String NOT_LOGGED_IN_ERROR = "You are not logged in. Please, sign in or create new account";
    private static final String CHECKOUT_COMMAND = "checkout";

    private final ApplicationContext applicationContext;
    private final ProductManagementService productManagementService;

    {
        productManagementService = ProductManagementServiceImpl.getInstance();
        applicationContext = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        Menu menuToNavigate;
        while(true) {
            printMenuHeader();
            printProducts();
            String userInput = readUserInput();
            //  Main Menu Command
            if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
                menuToNavigate = applicationContext.getMainMenu();
                break;
            }
            // Checkout Command
            if (userInput.equalsIgnoreCase(CHECKOUT_COMMAND)) {
                Cart sessionCart = applicationContext.getSessionCart();
                if (sessionCart == null || sessionCart.isEmpty()) {
                    System.out.println(EMPTY_CART_ERROR);
                } else {
                    menuToNavigate = new CheckoutMenu();
                    break;
                }
            }
            // Check Authentication State
            if (applicationContext.getLoggedInUser() == null) {
                System.out.println(NOT_LOGGED_IN_ERROR);
                menuToNavigate = applicationContext.getMainMenu();
                break;
            }
            // Add Product to Cart
            else {
                Product selectedProduct = fetchProduct(userInput);

                if (selectedProduct != null) {
                    addProductToChart(selectedProduct);
                } else {
                    System.out.println(ADD_PRODUCT_TO_CART_ERROR);
                }
            }
        }
        menuToNavigate.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** PRODUCT CATALOG *****");
        System.out.println(USER_PROMPT);
        System.out.println("***************************");
    }

    private void printProducts() {
        Arrays.stream(productManagementService.getProducts())
                .forEach(System.out::println);
    }

    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private Product fetchProduct(String userInput) {
        int selectedProductId = Integer.parseInt(userInput);
        return productManagementService.getProductById(selectedProductId);
    }

    private void addProductToChart(Product product) {
        applicationContext.getSessionCart().addProduct(product);
        System.out.printf(ADD_PRODUCT_TO_CART_SUCCESS, product.getProductName());
    }
}
