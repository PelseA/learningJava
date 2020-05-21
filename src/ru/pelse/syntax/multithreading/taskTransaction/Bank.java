package ru.pelse.syntax.multithreading.taskTransaction;

import java.util.HashSet;

public class Bank {
    public static void main(String[] args) {
        Account account1 = new Account(17400);
        Account account2 = new Account(20000);
        Account account3 = new Account(68000);
        Account account4 = new Account(9000);
        Account account5 = new Account(93000);

        TransactionGenerator transactionGenerator = new TransactionGenerator();
        transactionGenerator.generateTransaction(account1, account2, 1200);
        transactionGenerator.generateTransaction(account2, account3, 5000);
        transactionGenerator.generateTransaction(account4, account2, 50);
        transactionGenerator.generateTransaction(account5, account1, 3000);
        transactionGenerator.generateTransaction(account3, account2, 350);
        transactionGenerator.generateTransaction(account2, account5, 1150);
        transactionGenerator.generateTransaction(account4, account1, 3500);
    }

}

class TransactionGenerator {
    HashSet<Thread> transactionThreads = new HashSet<>();
    public void generateTransaction(Account account1, Account account2, int moneySum) {
        transactionThreads.add(new Thread(new Transaction(account1, account2, moneySum)));
        for (Thread trThread : transactionThreads) {
            if (trThread.getState().equals(Thread.State.NEW)) {
                trThread.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

