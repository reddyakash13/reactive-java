package com.learning.rxjava.conditional;

import com.learning.rxjava.util.DataGenerator;

import rx.Observable;

public class BooleanConditionalContainsAndExists {

	public static void main(String[] args) {

		// Create an observable from out big list of integers
		Observable.from(DataGenerator.generateBigIntegerList())
				// Test to see if the list contains the number 100
				.contains(100)
				// Subscribe to the boolean result.
				.subscribe((b) -> {
					if (b == true) {
						System.out.println("contains evaluated to true - the number 100 is present");
					} else {
						System.out.println("contains evaluated to false - the number 100 is not present");
					}
				});

		System.out.println();

		// Create an observable from out big list of integers
		Observable.from(DataGenerator.generateBigIntegerList())
				// Test to see if the list contains the number 100
				.exists((i) -> {
					return i == 100;
				})
				// Subscribe to the boolean result.
				.subscribe((b) -> {
					if (b == true) {
						System.out.println("exists evaluated to true - the number 100 exists in the list");
					} else {
						System.out.println("exists evaluated to false - the number 100 does not exist in the list");
					}
				});

		System.out.println();

		System.exit(0);
	}
}
