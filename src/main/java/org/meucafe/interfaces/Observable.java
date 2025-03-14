package org.meucafe.interfaces;

import org.meucafe.Kitchen;

public interface Observable {
    public void attach(Kitchen kitchen);
    public void detach(Kitchen kitchen);
    public void notifyObservers(Kitchen kitchen);
    public void addOrder(Order order);
}
