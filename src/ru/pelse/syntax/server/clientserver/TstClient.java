package ru.pelse.syntax.server.clientserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TstClient {
    public static void main(String[] args) {
        System.out.println("The client program is ready to work. ");
        Properties properties = new Properties();

        try (InputStream input = Server.class.getClassLoader()
                .getResourceAsStream("socket.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.getProperty("port").trim());

        String ip = properties.getProperty("ip");
        Client client = new Client(ip, port);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 1L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(512));

        try {
            client.start();
            //TODO: я не разобралась, где стартовать поток clientReader
            //сначала он был не в executor
            //executor.submit(new ClientReader(client.getSocket()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
