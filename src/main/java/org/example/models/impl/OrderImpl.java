package org.example.models.impl;

import org.example.models.Order;
import org.example.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OrderImpl implements Order {

    private String creditCardNumber;
    private List<Product> products;
    private int customerId;

    {
        products = new ArrayList<>();
    }

    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        String regex = "\\d{16}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {
        if (creditCardNumber == null) {
            return;
        }
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        return "creditCardNumber='" + creditCardNumber + '\n' + "customerId=" + customerId +'\n' +
                "***** Products *****\n" + products.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));

    }
}
