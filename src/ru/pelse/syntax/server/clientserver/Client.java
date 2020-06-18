package ru.pelse.syntax.server.clientserver;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.UUID;

public class Client implements Serializable {
    private String ip;
    private int port;
    private Scanner scanner;
    String uniqueID = UUID.randomUUID().toString();

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public Socket getSocket() {
        try {
            return new Socket(ip, port);
        } catch (IOException e) {
            // System.out.println("Сервер недоступен");
            return null;
        }
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public void start() throws Exception {
        // /exit
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        String text;

        while (true) {
            System.out.println("Введите сообщение");
            text = scanner.nextLine();
            try {
                ClientSender clientSender = new ClientSender(this.getSocket());
                clientSender.sendMessage(Message.getInstance(name, text, this.getUniqueID()));

            } catch (SocketException e) {
                System.out.println("Server unavailable, try connecting later.");
                break;
            }
        }
    }

}
