package com.herokiran.corejava.consoleprograms.restuarant;

class Restuarant {
    private boolean foodReady = false;

    public synchronized void cookFood() throws InterruptedException {
        System.out.println("chef is cooking the food");
        Thread.sleep(8000);
        foodReady = true;
        System.out.println("chefs food is ready");
        notify();

    }

    public synchronized void serveFood() throws InterruptedException {
        while (!foodReady) {
            System.out.println("waiter waiting for the food");
            wait();
        }
        System.out.println("waiter serving food to the customer");

    }
}

class chef implements Runnable {
    private Restuarant restuarant;


    public chef(Restuarant restuarant) {
        this.restuarant = restuarant;
    }

    @Override
    public void run() {
        try {
            restuarant.cookFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class waiter implements Runnable{
    private  Restuarant restuarant;

    public waiter(Restuarant restuarant) {
        this.restuarant = restuarant;
    }

    @Override
    public void run() {
        try {
            restuarant.serveFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class threadCommunicationRunnable {
    public static void main(String[] args) {
       Restuarant restuarant = new Restuarant();
        Thread waiterThread = new Thread(new waiter(restuarant));
        Thread chefThread = new Thread(new chef(restuarant));

        waiterThread.start();
        chefThread.start();

    }

}