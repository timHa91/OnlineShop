package org.example.models.impl;

import org.example.models.Order;
import org.example.models.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderImpl implements Order {

    private String creditCardNumber;
    private Product[] products;
    private int customerId;
    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        String regex = "\\d{16}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches() ? true :false;
    }

    @Override
    public void setCreditCardNumber(String userInput) {
        this.creditCardNumber = userInput;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }
}
