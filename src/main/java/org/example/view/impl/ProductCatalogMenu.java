package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.models.Product;
import org.example.services.impl.ProductManagementServiceImpl;
import org.example.view.Menu;

import java.util.Arrays;
import java.util.Scanner;

public class ProductCatalogMenu implements Menu {

    private static final String USER_PROMPT = "Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu";
    private static final String ADD_PRODUCT_TO_CART_ERROR = "Please, enter product ID if you want to add product to cart. Or enter ‘checkout’ if you want to proceed with checkout. Or enter ‘menu’ if you want to navigate back to the main menu.";
    private static final String ADD_PRODUCT_TO_CART_SUCCESS = "Product %s has been added to your cart. If you want to add a new product - enter the product id. If you want to proceed with checkout - enter word ‘checkout’ to console\n";

    private static final String CHECKOUT_COMMAND = "checkout";

    private final ApplicationContext applicationContext;
    private final ProductManagementServiceImpl productManagementService;

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

            if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
                menuToNavigate = applicationContext.getMainMenu();
                break;
            }

            if (userInput.equalsIgnoreCase(CHECKOUT_COMMAND)) {
                menuToNavigate = new CheckoutMenu();
                break;
            }

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
