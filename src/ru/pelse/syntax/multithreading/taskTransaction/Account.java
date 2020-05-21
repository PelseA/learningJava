package ru.pelse.syntax.multithreading.taskTransaction;

public class Account {

    private int id; // unique (1,2,3,4,5...)
    private int balance; // доступные средства на аккаунте
    private static int incId = 0;

    public Account(int balance) {
        setId();
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public synchronized void setId() {
        this.id = incId++;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}