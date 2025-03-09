package org.meucafe;

import org.meucafe.interfaces.Product;

import java.util.List;

public class Order {
    private String customerName;
    private List<Product> products;
    private double totalPrice = 0;

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public double getTotalPrice() {
        for (Product product : this.products) {
            this.totalPrice += product.getPrice();
        }

        return this.totalPrice;
    }
}
