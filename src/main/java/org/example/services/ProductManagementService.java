package org.example.services;

import org.example.models.Product;

public interface ProductManagementService {

    Product[] getProducts();

    Product getProductById(int productIdToAddToCart);

}

