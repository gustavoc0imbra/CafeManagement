package org.meucafe.interfaces;

import org.meucafe.Order;

public interface Observer {
    public void update(Order order);
}
