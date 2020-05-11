package ru.pelse.syntax.server.messages;

import ru.pelse.syntax.server.messages.handler.CommandHandler;
import ru.pelse.syntax.server.messages.handler.HelpHandler;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class Server {
    private int port;
    private Connection connection;
    private int countConnection = 0;
    private HashSet<Integer> ports = new HashSet<>();

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket.toString());

                if (!ports.contains(clientSocket.getLocalPort())) {
                    ports.add(clientSocket.getLocalPort());
                    countConnection++;
                }

                connection = new Connection(clientSocket);
                SimpleMessage query = connection.readMessage();
                String textQuery = query.getText().toLowerCase().trim();
                System.out.println(query);
                try{
                    switch (textQuery) {
                        case "/count":
                            connection.sendMessage(SimpleMessage.getInstance("server",
                                    "количество подключений " + countConnection));
                            break;
                        case "/ping":
                            connection.sendMessage(SimpleMessage.getInstance("server", "время запроса: "
                                    + (LocalDateTime.now().getMinute() - query.getDateTime().getMinute()) + " минут "
                                    + (LocalDateTime.now().getSecond() - query.getDateTime().getSecond()) + " секунд "
                                    + (LocalDateTime.now().getNano() - query.getDateTime().getNano()) + " наносекунд"));
                            break;
                        case "/exit":
                            connection.sendMessage(SimpleMessage.getInstance("server", "спасибо, что заглянули"));
                            clientSocket.close();
                            try {
                                connection.close();
                            } catch (Exception e) {
                                System.out.println("Сервер недоступен");
                                e.printStackTrace();
                            }
                            countConnection--;

                            break;
                        default: {
                            CommandHandler commandHandler = new HelpHandler();
                            commandHandler.execute(connection);
                            break;
                        }
                    }
                } catch(SocketException e) {
                    System.out.println("программа-клиент отсоединилась");
                }
            }
        }
    }


    public static void main(String[] args) {
        int port = 8099;
        Server server = new Server(port);
        try {
            server.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
