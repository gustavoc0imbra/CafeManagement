package org.meucafe;

import org.meucafe.enums.OrderStatus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Kitchen {
    private Queue<Order> pendingOrders = new LinkedList<Order>();

    public Queue<Order> getPendingOrders() {
        return pendingOrders;
    }

    public void addOrder(Order order) {
        pendingOrders.add(order);
        System.out.println("Pedido: #" + order.hashCode() + " enviado à cozinha!");
    }

    public void cook(Order order) {
        order.setOrderStatus(OrderStatus.PREPARING);
        System.out.println("Cozinha preparando Pedido: #" + order.hashCode());

    }


}
