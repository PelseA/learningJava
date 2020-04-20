package ru.pelse.syntax.hw;

import java.util.HashSet;
import java.util.List;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого приоритета
        int countHigh = 0;
        int countUrgent = 0;
        int countMedium = 0;
        int countLow = 0;
        for (Message message: messageList) {
            if (message.getPriority().equals(MessagePriority.URGENT)) countUrgent++;
            if (message.getPriority().equals(MessagePriority.HIGH)) countHigh++;
            if (message.getPriority().equals(MessagePriority.MEDIUM)) countMedium++;
            if (message.getPriority().equals(MessagePriority.LOW)) countLow++;
        }

        System.out.println("count message Urgent: " + countUrgent + "\n"
                            + "count message High: " + countHigh + "\n"
                            + "count message Medium: " + countMedium + "\n"
                            + "count message Low: " + countLow + "\n");

    }

    public static void countEachCode(List<Message> messageList) {
        //Подсчитать количество сообщений для каждого кода сообщения
        //поместим уникальные коды в сет
        HashSet<Integer> codes = new HashSet<>();
        //для Integer сразу получим упорядоченный по возрастанию
        for (Message message: messageList) {
            codes.add(message.getCode());
        }
        int count;
        for (Integer code: codes) {
            count = 0;
            for (Message message: messageList) {
                if(code == message.getCode()) {
                    count++;
                }
            }
            System.out.println("for code " + code + " count of messages = " + count);
        }

    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
    }

    public static void main(String[] args) {
        // вызов методов
        List<Message> messages = MessageGenerator.generate(24);
        System.out.println(messages);
        MessageTask.countEachPriority(messages);
        MessageTask.countEachCode(messages);
    }
}
