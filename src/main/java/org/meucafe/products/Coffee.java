package org.meucafe.products;

import org.meucafe.interfaces.Product;

public class Coffee implements Product {
    private String name = "Coffee";
    private double price = 2.20;


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
