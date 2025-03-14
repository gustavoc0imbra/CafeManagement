package org.meucafe;

import org.meucafe.enums.OrderStatus;
import org.meucafe.interfaces.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private String customerName;
    private List<Product> products = new ArrayList<Product>();
    private OrderStatus orderStatus = OrderStatus.PENDING;

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, products);
    }

    public void addProduct(Product product) {
        if (products == null) {
            throw new IllegalArgumentException("Produto inválido!");
        }

        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public double getTotalPrice() {
        double total = 0;

        for (Product product : this.products) {
            total += product.getPrice();
        }

        return total;
    }

    public String formattedOutput() {
        String output = "";

        output = "+---------PEDIDO %s---------+\n".formatted(this.hashCode());
        output += "Cliente: %s \n".formatted(this.customerName);
        output += "# - Nome Produto - Preço\n";

        for (int index = 0; index < this.getProducts().size(); index++) {
            output += "%d - %s - %.2f \n".formatted(index + 1, this.products.get(index).getName(), this.products.get(index).getPrice()) ;
        }

        output += "Sub-Total: R$ %.2f\n".formatted(this.getTotalPrice());

        output += "+--------------------------+";

        return output;
    }
}
