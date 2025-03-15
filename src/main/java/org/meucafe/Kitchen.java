package org.meucafe;

import org.meucafe.enums.OrderStatus;
import org.meucafe.interfaces.Observer;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Kitchen implements Observer {
    private Queue<Order> pendingOrders = new LinkedList<Order>();

    public String getOrdersStatus() {

        if (pendingOrders.isEmpty()) {
            return "Não há nada pendente na cozinha!";
        }


        String orders = "+------STATUS PEDIDOS------+\n";

        for (Order order : pendingOrders) {
            orders += "| %d - %s |\n".formatted(order.hashCode(), order.getOrderStatus());
        }

        orders += "+------------------------+";

        return orders;
    }

    public void addOrder(Order order) {
        pendingOrders.add(order);
        System.out.println("Pedido: #" + order.hashCode() + " enviado à cozinha!");
    }

    public void removeOrder(Order order) {
        order.setOrderStatus(OrderStatus.DONE);
        pendingOrders.remove(order);
        System.out.println("Pedido: #"+order.hashCode() + " terminado!\nFavor chamar: " + order.getCustomerName());
        JOptionPane.showMessageDialog(null, "Pedido: #"+order.hashCode() + " terminado!\nFavor chamar: " + order.getCustomerName());
    }

    public void cook(Order order) {
        order.setOrderStatus(OrderStatus.PREPARING);

        System.out.println("Cozinha preparando Pedido: #" + order.hashCode());

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(Order order) {
        addOrder(order);
        Thread t = new Thread(() -> {
            cook(order);
            removeOrder(order);
        });
        t.start();
    }
}
