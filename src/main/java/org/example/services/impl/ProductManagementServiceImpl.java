package org.example.services.impl;

import org.example.models.Product;
import org.example.services.ProductManagementService;

public class ProductManagementServiceImpl implements ProductManagementService {
    @Override
    public Product[] getProducts() {
        return new Product[0];
    }

    @Override
    public Product getProductById(int productIdToAddToCart) {
        return null;
    }
}
