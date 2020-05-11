package ru.pelse.syntax.server.messages.handler;

import ru.pelse.syntax.server.messages.Connection;

public interface CommandHandler {
     void execute(Connection connection);
}
