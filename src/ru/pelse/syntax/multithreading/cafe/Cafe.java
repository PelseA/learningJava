package ru.pelse.syntax.multithreading.cafe;

import java.util.concurrent.LinkedBlockingDeque;

public class Cafe {
    public static void main(String[] args) {
        LinkedBlockingDeque<Order> fromClientToWaiter = new LinkedBlockingDeque<>(10);
        LinkedBlockingDeque<Order> fromWaiterToCook = new LinkedBlockingDeque<>(10);
        LinkedBlockingDeque<Order> fromCookToClient = new LinkedBlockingDeque<>(10);

        Thread clientThread = new Thread(new Client(fromClientToWaiter, fromCookToClient));
        clientThread.start();
        Thread waiterThread = new Thread(new Waiter(fromClientToWaiter, fromWaiterToCook));
        waiterThread.start();
        Thread cookThread = new Thread(new Cook(fromWaiterToCook, fromCookToClient));
        cookThread.start();
    }
}








