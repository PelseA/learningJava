package ru.pelse.syntax.server.clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class ServerReader implements Runnable {
    private LinkedBlockingDeque<Message> messageQueue;
    private Socket clientSocket;
    private ObjectInputStream input;
    private Message message;
    private ConcurrentHashMap<Socket, String> senders;

    public ServerReader(Socket clientSocket, LinkedBlockingDeque<Message> messageQueue,
                        ConcurrentHashMap<Socket, String> senders) throws IOException {
        this.messageQueue = messageQueue;
        this.clientSocket = clientSocket;
        this.input = new ObjectInputStream(this.clientSocket.getInputStream());
        this.senders = senders;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                message = (Message) input.readObject();
                senders.replace(clientSocket, "", message.getSenderId());
                System.out.println("message-> " + message.toString());
                messageQueue.add(message);
                System.out.println("reader add message: Size= " + messageQueue.size());
            } catch (IOException e) {
                System.out.println("Программа-клиент отсоединилась");
                senders.remove(clientSocket); //убрали сокет отсоединившегося клиента
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
