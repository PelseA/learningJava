package ru.pelse.syntax.hw;

import java.util.*;

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
        // Подсчитать количество уникальных сообщений
        HashSet<Message> unique = new HashSet<>();
        int count = 0;
        for (Message message: messageList) {
            if(unique.add(message)) {
                count++;
            }
        }
        System.out.println("Unique messages = " + count);

    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //для первоначального порядка используем LinkedHashSet (хранит элементы в порядке добавления)
        LinkedHashSet<Message> messages = new LinkedHashSet<>(messageList);
        return new ArrayList<>(messages);
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции каждое сообщение с заданным приоритетом
        // вывод в консоль до удаления и после удаления
        System.out.println("Before remove by priority " + priority + ": \n" + messageList);
        Iterator<Message> messageIterator = messageList.iterator();
        //здесь не буду применять лямбду, так как мы ее еще не проходили
        while(messageIterator.hasNext()) {
            Message nextMes = messageIterator.next();
            if (nextMes.getPriority().equals(priority)) {
                messageIterator.remove();
            }
        }
        System.out.println("After remove: \n" + messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println("Before remove messages except priority " + priority + ": \n" + messageList);
        Iterator<Message> messageIterator = messageList.iterator();
        //и здесь не буду применять лямбду, так как мы ее еще не проходили
        while(messageIterator.hasNext()) {
            Message nextMes = messageIterator.next();
            if (!nextMes.getPriority().equals(priority)) {
                messageIterator.remove();
            }
        }
        System.out.println("After remove: \n" + messageList);
    }

    public static void main(String[] args) {
        // вызов методов
        List<Message> messages = MessageGenerator.generate(14);
        System.out.println(messages);
        MessageTask.countEachPriority(messages);
        MessageTask.countEachCode(messages);
        MessageTask.uniqueMessageCount(messages);
        System.out.println(MessageTask.uniqueMessagesInOriginalOrder(messages));
        MessageTask.removeEach(messages, MessagePriority.HIGH);
        MessageTask.removeOther(messages, MessagePriority.LOW);
    }
}
