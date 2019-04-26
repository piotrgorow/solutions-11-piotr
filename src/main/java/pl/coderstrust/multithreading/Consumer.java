package pl.coderstrust.multithreading;

import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int retrieveFrequencyInMillis;
    private String name;

    public Consumer(BlockingQueue<Integer> queue, int retrieveFrequencyInMillis, String name) {
        this.queue = queue;
        this.retrieveFrequencyInMillis = retrieveFrequencyInMillis;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(retrieveFrequencyInMillis);
                System.out.println("Consumer " + name + " take: " + queue.remove() + " remaining queue " + queue.remainingCapacity());
            } catch (NoSuchElementException | InterruptedException e) {
                System.out.println("Queue is empty - consumer " + name + " is waiting...");
            }
        }
    }
}
