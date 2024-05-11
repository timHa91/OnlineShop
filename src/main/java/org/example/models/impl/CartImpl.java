package org.example.models.impl;

import org.example.models.Cart;
import org.example.models.Product;

public class CartImpl implements Cart {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void addProduct(Product productById) {

    }

    @Override
    public Product[] getProducts() {
        return new Product[0];
    }

    @Override
    public void clear() {

    }
}
