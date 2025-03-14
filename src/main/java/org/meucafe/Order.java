package org.meucafe;

import org.meucafe.interfaces.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<Product> products = new ArrayList<Product>();
    private double totalPrice = 0;

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public List<Product> getProducts() {
        return products;
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
