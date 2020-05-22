package ru.pelse.syntax.multithreading.taskTransaction;

import java.util.Objects;

public class Transaction implements Runnable {
    final private Account accountOutput; // с какого аккаунта осуществлять перевод
    final private Account accountInput; // на какой аккаунт осуществлять перевод
    private int moneySum; // сколько переводить

    public Transaction(Account accountOutput, Account accountInput, int moneySum) {
        this.accountOutput = accountOutput;
        this.accountInput = accountInput;
        this.moneySum = moneySum;
    }

    @Override
    public void run() {
        // перевод средств в количестве (moneySum) с аккаунта (accountOutput)
        synchronized (accountOutput) {
            System.out.println(accountOutput.hashCode() + " Баланс accountOutput перед отправкой денег: "
                    + accountOutput.getBalance());

            if (accountOutput.getBalance() >= moneySum) {
                accountOutput.setBalance(accountOutput.getBalance() - moneySum);
                System.out.println(accountOutput.hashCode() + " Баланс accountOutput после отправки денег: " +
                        accountOutput.getBalance());
                synchronized (accountInput) {
                    System.out.println("current thread " + Thread.currentThread().getName());
                    System.out.println(accountInput.hashCode() + " Баланс accountInput до зачисления денег: " +
                            accountInput.getBalance());
                    accountInput.setBalance(accountInput.getBalance() + moneySum);
                    System.out.println(accountInput.hashCode() + " Баланс accountInput после зачисления денег: " +
                            accountInput.getBalance());
                }
            } else System.out.println("Недостаточно средств. Баланс: " + accountOutput.getBalance());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return moneySum == that.moneySum &&
                Objects.equals(accountOutput, that.accountOutput) &&
                Objects.equals(accountInput, that.accountInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountOutput, accountInput, moneySum);
    }
}