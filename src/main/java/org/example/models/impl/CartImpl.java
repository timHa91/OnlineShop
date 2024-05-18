package org.example.models.impl;

import org.example.models.Cart;
import org.example.models.Product;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CartImpl implements Cart {

    private final List<Product> products;

    {
        products = new ArrayList<>();
    }
    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public void addProduct(Product productById) {
        if (productById == null) {
            return;
        }

        products.add(productById);
    }

    @Override
    public List<Product> getProducts() {
        return this.products;
    }

    @Override
    public void clear() {
        products.clear();
    }
}
