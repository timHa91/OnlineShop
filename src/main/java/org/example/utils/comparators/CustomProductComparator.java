package org.example.utils.comparators;

import org.example.models.Product;

import java.util.Comparator;

public class CustomProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product product, Product t1) {
        int result = product.getProductName().compareTo(t1.getProductName());
        if (result == 0) {
            result = Double.compare(product.getPrice(), t1.getPrice());
            if (result == 0) {
                result = product.getCategoryName().compareTo(t1.getCategoryName());
            }
        }
        return result;
    }
}
