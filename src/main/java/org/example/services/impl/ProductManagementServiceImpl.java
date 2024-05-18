package org.example.services.impl;

import org.example.models.Product;
import org.example.models.impl.ProductImpl;
import org.example.services.ProductManagementService;

import java.util.ArrayList;
import java.util.List;

public class ProductManagementServiceImpl implements ProductManagementService {

    private static ProductManagementServiceImpl instance;

    private static List<Product> products;

    private ProductManagementServiceImpl() {
        initProducts();
    }

    private static void initProducts() {
        products = new ArrayList<>(List.of(
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
        ));
    }

    public static ProductManagementServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductManagementServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int productIdToAddToCart) {
        if (productIdToAddToCart > 0) {
            return products.stream()
                    .filter(product -> product != null && product.getId() == productIdToAddToCart)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
}
