package ru.pelse.syntax.server.clientserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

public class Server {
    private int port;
    //private CopyOnWriteArraySet<Socket> clientSockets;
    private ConcurrentHashMap<Socket, String> sendersInfo;

    public Server(int port) {
        this.port = port;
        //clientSockets = new CopyOnWriteArraySet<>();
        sendersInfo = new ConcurrentHashMap<>(20);
    }

    public void start() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running...");
            LinkedBlockingDeque<Message> messageQueue = new LinkedBlockingDeque<>(20);
            ServerSender sSender = new ServerSender(messageQueue);
            Thread serverSender = new Thread(sSender);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                sendersInfo.putIfAbsent(clientSocket, "");
                Thread serverReader = new Thread(new ServerReader(clientSocket, messageQueue, sendersInfo));
                serverReader.start();
                //clientSockets.add(clientSocket);
                sSender.setClientSockets(sendersInfo);
                if (!serverSender.isAlive() ) {
                    serverSender.start();
                    //System.out.println("serverSender state " + serverSender.getState());
                }
            }
        }
//        ServerSocket serverSocket = new ServerSocket(port);
//        System.out.println("Server is running...");
//        LinkedBlockingDeque<Message> messageQueue = new LinkedBlockingDeque<>(10);
//        ServerSender sSender = new ServerSender(messageQueue);
//        Thread serverSender = new Thread(sSender);
//        try {
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                Thread serverReader = new Thread(new ServerReader(clientSocket, messageQueue));
//                serverReader.start();
//                clientSockets.add(clientSocket);
//                sSender.setClientSockets(clientSockets);
//                if (!serverSender.isAlive()) {
//                    serverSender.start();
//                }
//
//            }
//        } finally {
//            serverSocket.close();
//        }
    }


}
