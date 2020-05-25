package ru.pelse.syntax.multithreading.cafe;

import java.util.concurrent.LinkedBlockingDeque;

public class Cook implements Runnable {
    private LinkedBlockingDeque<Order> fromWaiterToCook;
    private LinkedBlockingDeque<Order> fromCookToClient;

    public Cook(LinkedBlockingDeque<Order> fromWaiterToCook, LinkedBlockingDeque<Order> fromCookToClient) {
        this.fromWaiterToCook = fromWaiterToCook;
        this.fromCookToClient = fromCookToClient;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                //повар получит заказ из очереди с отсрочкой в 300 млс + 300 млс = 600 млс
                Thread.sleep(600);
                if (fromWaiterToCook.size() > 0) {
                    Order order = fromWaiterToCook.getLast();
                    System.out.println("Повар принял заказ: " + order);
                    fromWaiterToCook.removeFirstOccurrence(order);
                    System.out.println(cooking(order));
                    //повар передает заказ клиенту
                    fromCookToClient.put(order);
                }
            } catch (InterruptedException e) {
                System.out.println("Повар НЕ передал заказ клиенту");
                e.printStackTrace();
            }
        }
    }

    protected String cooking(Order order) {
        return "Повар приготовил заказ: " + order;
    }
}
