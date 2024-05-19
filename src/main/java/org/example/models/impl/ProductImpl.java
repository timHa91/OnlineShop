package org.example.models.impl;

import org.example.models.Product;

public class ProductImpl implements Product {

    private static int productCreatedCount;

    private final int id;
    private final String productName;
    private final String categoryName;
    private double price;

    public ProductImpl(String productName, String categoryName, double price) {
        productCreatedCount++;
        this.id = productCreatedCount;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + productName
                + ", category=" + categoryName + ", price=" + price;
    }

}
