package ru.pelse.syntax.server.clientserver;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSender {
    private ObjectOutputStream output;

    public ClientSender(Socket socket) {
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException | NullPointerException e) {
            System.out.println("Сервер недоступен. Попробуйте позднее");
        }
    }

    public void sendMessage(Message message) throws Exception {
        message.setDateTime();
        try {
            output.writeObject(message);
            output.flush();
        } catch (NullPointerException e) {}
    }
}
