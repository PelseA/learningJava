package ru.pelse.syntax.server.clientserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TstServer {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream input = Server.class.getClassLoader()
                .getResourceAsStream("socket.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.getProperty("port").trim());
        Server server = new Server(port);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
