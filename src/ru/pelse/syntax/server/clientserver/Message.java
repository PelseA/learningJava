package ru.pelse.syntax.server.clientserver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String senderId;
    private String senderName;
    private String text;
    private LocalDateTime dateTime;

    public Message(String senderName, String text, String senderId) {
        this.senderName = senderName;
        this.text = text;
        this.senderId = senderId;
    }

    public Message() {
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Message{" +
                "senderId='" + senderId + '\'' +
                ", senderName='" + senderName + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public static Message getInstance(String senderName, String text, String senderId){
        return new Message(senderName, text, senderId);
    }
}