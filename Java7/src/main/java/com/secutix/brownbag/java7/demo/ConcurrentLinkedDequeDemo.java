package com.secutix.brownbag.java7.demo;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple demo of ConcurrentLinkedDeque.
 * <p>
 * 
 * @author Sebastien Caille (SCA)
 */
public class ConcurrentLinkedDequeDemo {

    // a queue, with max. size = 20
    public static Deque<Integer> queue = new ConcurrentLinkedDeque<>();

    public static void main(final String[] args) {

        // Reader
        final Thread reader = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // Wait a bit before reading the queue, so we can have a
                        // few elements in the queue
                        Thread.sleep(ThreadLocalRandom.current().nextLong(1, 1000));

                        // Poll the head of the queue
                        final Integer value = queue.pollFirst();
                        if (value != null) {
                            System.out.println("Reader thread: " + value);
                        }
                    } catch (final InterruptedException e) {
                        // just leave
                        return;
                    }
                }
            }
        };
        reader.start();

        // Feed the queue
        int i = 0;
        while (true) {
            try {
                if (queue.size() < 20) {
                    queue.addLast(Integer.valueOf(i++));
                }

                Thread.sleep(450);
            } catch (final InterruptedException e) {
                // just leave
                return;
            }
        }

    }
}
