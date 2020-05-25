package ru.pelse.syntax.multithreading.cafe;

import java.util.concurrent.LinkedBlockingDeque;

public class Client implements Runnable {
    private Order order;
    private LinkedBlockingDeque<Order> fromClientToWaiter;
    private LinkedBlockingDeque<Order> fromCookToClient;

    public Client(LinkedBlockingDeque<Order> fromClientToWaiter, LinkedBlockingDeque<Order> fromCookToClient) {
        this.fromClientToWaiter = fromClientToWaiter;
        this.fromCookToClient = fromCookToClient;
    }

    public Order getOrder() {
        return order;
    }

    //клиент получит заказ обратно примерно через 1000 млс
    //отдает официанту; официант готов передать его через 300 млс;
    //повар примется за его выполнение еще через 300 млс (300+300)
    //клиент получит его через 1000 млс (600+400)
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            //заказы всегда разные
            order = new Order();
            System.out.println("Клиент сделал заказ: " + order);
            try {
                fromClientToWaiter.put(this.order);
            } catch (InterruptedException e) {
                System.out.println("Заказ НЕ принят. Ошибка обработки заказа от клиента.");
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
                if (fromCookToClient.size() > 0) {
                    Order readyOrder = fromCookToClient.getFirst();
                    System.out.println("Клиент получил заказ: " + readyOrder);
                    fromCookToClient.removeFirstOccurrence(readyOrder);
                }
            } catch (InterruptedException e) {
                System.out.println("Клиент НЕ получил заказ");
                e.printStackTrace();
            }
        }
    }
}
