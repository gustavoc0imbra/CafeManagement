package org.meucafe.decorators;

import org.meucafe.interfaces.Product;

public class ChocolateCoverDecorator extends ProductDecorator {
    private final double PRICE = 2.30;

    public ChocolateCoverDecorator(Product product) {
        super(product);
    }

    @Override
    public String getName() {
        return super.getName() + ", Chocolate";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE;
    }
}
