package com.learning.rxjava.conditional;

import com.learning.rxjava.util.DataGenerator;

import rx.Observable;

public class BooleanConditionalAll {

	public static void main(String[] args) {

		// Create an observable from out big list of integers
		Observable.from(DataGenerator.generateBigIntegerList())
				// Test to see if the numbers are greater than 0
				.all((i) -> {
					return i >= 0;
				})
				// Subscribe to the boolean result.
				.subscribe((b) -> {
					if (b == true) {
						System.out.println("all evaluated to true - all numbers >= 0");
					} else {
						System.out.println("all evaluated to false - not all numbers >= 0");
					}
				});

		System.out.println();

		// Create another observable from the big list of integers
		Observable.from(DataGenerator.generateBigIntegerList())
				// Test to see if all the numbers are even numbers...
				.all((i) -> {
					return i % 2 == 0;
				})
				// Subscribe to the resultant boolean
				.subscribe((b) -> {
					if (b == true) {
						System.out.println("all evaluated to true - all numbers are even");
					} else {
						System.out.println("all evaluated to false - not all numbers are even");
					}
				});

		System.exit(0);
	}
}
