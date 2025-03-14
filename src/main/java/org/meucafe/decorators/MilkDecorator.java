package org.meucafe.decorators;

import org.meucafe.interfaces.Product;

public class MilkDecorator extends ProductDecorator {
    private final double PRICE = 1.50;

    public MilkDecorator(Product product) {
        super(product);
    }

    @Override
    public String getName() {
        return super.getName() + ", Milk";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE;
    }

}
