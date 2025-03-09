package org.meucafe.factories;

import org.meucafe.interfaces.Product;
import org.meucafe.products.Cake;
import org.meucafe.products.Coffee;

public class ProductFactory {

    public static Product create(String productName) {
        Product product;
        switch (productName.toLowerCase()) {
            case "coffee":
                product = new Coffee();
                break;
            case "cake":
                product = new Cake();
                break;
            default:
                product = null;
        }
        return product;
    }
}
