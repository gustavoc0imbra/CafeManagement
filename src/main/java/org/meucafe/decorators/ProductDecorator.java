package org.meucafe.decorators;

import org.meucafe.interfaces.Product;

public abstract class ProductDecorator implements Product {
    private Product product;

    public ProductDecorator(Product product) {
        this.product = product;
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }
}
