package ru.pelse.syntax.server.messages;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())){
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            System.out.println("ответ от сервера " + fromServer);
        }
    }

    public void start() throws Exception {
        // /help
        // /count
        // /exit
        // /ping
        System.out.println("Ведите имя");
        String name = scanner.nextLine();
        String text;
        while (true){
            System.out.println("Введите сообщение");
            text = scanner.nextLine();
            try {
                sendAndPrintMessage(SimpleMessage.getInstance(name, text));
            } catch (SocketException e) {
                System.out.println("сервер недоступен, попробуйте подключиться позднее");
                break;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Программа клиент: ");
        Properties properties = new Properties();
        try (InputStream input = Server.class.getClassLoader()
                .getResourceAsStream("socket.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.getProperty("port").trim());

        String ip = properties.getProperty("ip");

        try {
            new Client(ip, port).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
