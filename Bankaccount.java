package com.herokiran.corejava.consoleprograms;

public class Bankaccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " TRYING TO WITHDREW " + amount);
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + "PROCESSING WITHDRAWAL");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " COMPLETED WITHDRAWAL . REMAINING BALANCE :" + balance);
        } else {
            System.out.println("INSUFFICIENT BALANCE");
        }
    }
}


