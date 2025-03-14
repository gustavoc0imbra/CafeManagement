package org.meucafe.products;

import org.meucafe.interfaces.Product;

public class Cake implements Product {
    private String name = "Bolo";
    private double price = 4.10;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
