package ru.pelse.syntax.server.clientserver;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.BiConsumer;

public class ServerSender implements Runnable {
    private LinkedBlockingDeque<Message> messageQueue;
    //private CopyOnWriteArraySet<Socket> clientSockets;
    private ConcurrentHashMap<Socket, String> sendersInfo;
    private ObjectOutputStream output;
    private Message message;

    public ServerSender(LinkedBlockingDeque<Message> messageQueue) {
        this.messageQueue = messageQueue;
    }

    public void setClientSockets(/*CopyOnWriteArraySet<Socket> clientSockets*/ ConcurrentHashMap<Socket, String> sendersInfo) {
        this.sendersInfo = sendersInfo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //TODO: всем, кроме отправителя данного сообщения
            //не добавила, так как не справилась с выводом в консоль клиенту входящего сообщения
            if (messageQueue.size() > 0) {
                sendersInfo.entrySet().stream().parallel().forEach(e -> {
                    try {
                        output = new ObjectOutputStream(e.getKey().getOutputStream());
                        System.out.println("output " + output);
                        if (messageQueue.size() > 0) {
                            message = messageQueue.getFirst();
                            messageQueue.removeFirst();
                            output.writeObject(message);
                            System.out.println("try send message");
                            output.flush();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }

        }
    }

}
