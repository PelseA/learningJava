package ru.pelse.syntax.multithreading.cafe;

import java.util.concurrent.LinkedBlockingDeque;

public class Waiter implements Runnable {
    private LinkedBlockingDeque<Order> fromClientToWaiter;
    private LinkedBlockingDeque<Order> fromWaiterToCook;

    public Waiter(LinkedBlockingDeque<Order> fromClientToWater, LinkedBlockingDeque<Order> fromWaiterToCook) {
        this.fromClientToWaiter = fromClientToWater;
        this.fromWaiterToCook = fromWaiterToCook;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(300);
                if(fromClientToWaiter.size() > 0) {
                    Order order = fromClientToWaiter.getLast();
                    System.out.println("Официант принял заказ: " + fromClientToWaiter);
                    fromWaiterToCook.put(order);
                    fromClientToWaiter.removeFirstOccurrence(order);
                }
            } catch (InterruptedException e) {
                System.out.println("Заказ НЕ дошел до повара");
                e.printStackTrace();
            }
        }
    }
}
