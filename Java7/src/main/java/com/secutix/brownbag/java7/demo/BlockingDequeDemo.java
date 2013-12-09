package com.secutix.brownbag.java7.demo;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * Simple demo of BlockingQue.
 * <p>
 * 
 * @author Sebastien Caille (SCA)
 */
public class BlockingDequeDemo {

	// a queue, with max. size = 20
	public static BlockingDeque<Integer> queue = new LinkedBlockingDeque<>(20);

	public static void main(final String[] args) {

		// Reader
		final Thread reader = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						// Wait a bit before reading the queue, so we can have more than one element in the queue
						Thread.sleep(ThreadLocalRandom.current().nextLong(1, 1000));
						// Take the head of the queue
						System.out.println("Reader thread: " + queue.take());
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
		int notblocked = 0;
		while (true) {
			try {
				final Stopwatch chrono = Stopwatch.createStarted();

				// Put the value, waiting until there is some free space available
				queue.putLast(Integer.valueOf(i++));

				long elapsed = chrono.elapsed(TimeUnit.MILLISECONDS);
				if (elapsed > 1) {
					System.out.println("putLast took " + elapsed + "ms, after " + notblocked + " non blocking calls");
					notblocked = 0;
				} else {
					notblocked++;
				}
				// Tuned (according to Thread.sleep of the reader) to entirely fill the queue from time to time
				Thread.sleep(350);
			} catch (final InterruptedException e) {
				// just leave
				return;
			}
		}

	}
}
