package org.example.services.impl;

import org.example.models.Product;
import org.example.models.impl.ProductImpl;
import org.example.services.ProductManagementService;

import java.util.Arrays;
import java.util.Objects;

public class ProductManagementServiceImpl implements ProductManagementService {

    private static ProductManagementServiceImpl instance;

    private static Product[] products;

    {
        initProducts();
    }

    private ProductManagementServiceImpl() {
    }

    private static void initProducts() {
        products = new Product[] {
                new ProductImpl( "Hardwood Oak Suffolk Internal Door", "Doors", 109.99),
                new ProductImpl("Oregon Cottage Interior Oak Door", "Doors", 179.99),
                new ProductImpl("Oregon Cottage Horizontal Interior White Oak Door", "Doors", 189.99),
                new ProductImpl("4 Panel Oak Deco Interior Door", "Doors", 209.09),
                new ProductImpl("Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller", "Boilers", 989.99),
                new ProductImpl("Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", 787.99),
                new ProductImpl("Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers", 859.99),
                new ProductImpl("Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)", "Bricks", 402.99),
                new ProductImpl("Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)", "Bricks", 659.99),
                new ProductImpl("Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks", 523.99)
        };
    }

    public static ProductManagementServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductManagementServiceImpl();
        }
        return instance;
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
    public Product getProductById(int productIdToAddToCart) {
        if (productIdToAddToCart > 0) {
            return Arrays.stream(products)
                    .filter(product -> product != null && product.getId() == productIdToAddToCart)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
}
