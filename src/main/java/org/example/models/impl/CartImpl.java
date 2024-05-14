package org.example.models.impl;

import org.example.models.Cart;
import org.example.models.Product;

import java.util.Arrays;
import java.util.Objects;

public class CartImpl implements Cart {

    private int productsInCart = 0;
    private static final int DEFAULT_PRODUCT_CAPACITY = 10;
    private Product[] products;

    {
        products = new Product[DEFAULT_PRODUCT_CAPACITY];
    }
    @Override
    public boolean isEmpty() {
        if (products == null || products.length == 0) {
            return true;
        }

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addProduct(Product productById) {
        if (productById == null) {
            return;
        }

        if (products.length <= productsInCart) {
            products = Arrays.copyOf(products, products.length << 1);
        }

        products[productsInCart++] = productById;
    }

    @Override
    public Product[] getProducts() {
        if (products != null) {
            return Arrays.stream(products)
                    .filter(Objects::nonNull)
                    .toArray(Product[]::new);
        }
        return null;
    }

    @Override
    public void clear() {
        products = new Product[DEFAULT_PRODUCT_CAPACITY];
        productsInCart = 0;
    }
}
