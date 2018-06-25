package com.learning.rxjava.save;

import static java.lang.System.out;

public class CarWithSideEffectsJava7 {

	private int remainingFuel;

	public CarWithSideEffectsJava7(int startingFuel) {
		this.remainingFuel = startingFuel;
	}

	public synchronized boolean hasFuel(int distance) {
		return distance <= remainingFuel;
	}

	public synchronized void move(int distance) {

		if (distance > remainingFuel) {
			throw new IllegalStateException(
					String.format("The car doesn't have the fuel to move %1s units.", distance));
		}
		remainingFuel -= distance;
	}

	private static void safeSleep(int milliseconds) {
		try {
			out.printf("%1s - Something stole your thread!  Your are going to sleep!\n",
					Thread.currentThread().getName());

			Thread.sleep(milliseconds);
		} catch (InterruptedException ex) {
		}
	}

	public static void main(String[] args) {

		try {
			CarWithSideEffectsJava7 c = new CarWithSideEffectsJava7(10);

			// Create thread 1
			Thread t1 = new Thread(new Runnable() {

				@Override
				public void run() {
					out.printf("Thread 1 started...\n");

					if (c.hasFuel(10)) {

						out.printf("Thread 1 - Car has the fuel to move 10 units!\n");

						// We have the fuel...move! But first, exagerage the
						// possible problem
						safeSleep(2000);

						c.move(10);

						out.printf("Thread 1 - I move the 10 units car!\n");
					}
				}

			}, "Thread #1");

			// Create thread 2
			Thread t2 = new Thread(new Runnable() {

				@Override
				public void run() {

					out.printf("Thread 2 started...\n");

					if (c.hasFuel(5)) {

						out.printf("Thread 2 - Car has the fuel to move 5 units!\n");

						// We have the fuel...move quickly
						c.move(5);

						out.printf("Thread 2 - I moved the car 5 units!\n");
					}
				}
			}, "Thread #2");

			// Start both threads...give thread 1 a chance to go first
			t1.start();
			Thread.sleep(100);
			t2.start();

			// Assuming we get here...join the threads before stopping
			t1.join();
			t2.join();
		} catch (InterruptedException t) {
		}

		System.exit(0);
	}
}
