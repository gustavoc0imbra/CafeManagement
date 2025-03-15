package org.meucafe.products;

import org.meucafe.interfaces.Product;

public class Coffee implements Product {
    private String name = "Café simples";
    private double price = 2.20;
    public static final String placeholder = "Café Simples R$ 2,20";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
