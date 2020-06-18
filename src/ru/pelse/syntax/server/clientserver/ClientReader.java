package ru.pelse.syntax.server.clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientReader implements Runnable {
    private ObjectInputStream input;
    private Socket socket;
    private Message message;

    public ClientReader(Socket socket) throws IOException {
        this.socket = socket;
        input = new ObjectInputStream(
                this.socket.getInputStream());
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (input.available() > 0) {
                    message = (Message)input.readObject();
                    System.out.println("Incoming message: " + message.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
