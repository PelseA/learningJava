package ru.pelse.syntax.server.messages.handler;

import ru.pelse.syntax.server.messages.Connection;
import ru.pelse.syntax.server.messages.SimpleMessage;

import java.io.IOException;

public class HelpHandler implements CommandHandler {
    @Override
    public void execute(Connection connection) {
        String commandList = "/help : список доступных команд \n " +
                "/ping : время за которое сообщение доходит до сервера и возвращается обратно \n" +
                "/count : количество подключений сервера \n" +
                "/exit : выход (завершение программы)";
        try {
            connection.sendMessage(SimpleMessage.getInstance("server", commandList));
        } catch (IOException e) {
            System.out.println("Проблема соединения");
            e.printStackTrace();
        }
    }
}
