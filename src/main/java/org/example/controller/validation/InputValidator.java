package org.example.controller.validation;

public class InputValidator {

    public static boolean validateMainMenuInput(String input) {
        if (input.equals("exit")) return true;
        try {
            int number = Integer.parseInt(input);
            if (number < 1 || number > 6) {
                System.out.println("Error: Only 1, 2, 3, 4, 5, 6 is allowed. Try one more time.");
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
            return false;
        }
    }
}
