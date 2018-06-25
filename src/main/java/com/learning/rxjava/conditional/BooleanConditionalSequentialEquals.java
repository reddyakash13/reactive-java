package com.learning.rxjava.conditional;

import com.learning.rxjava.util.DataGenerator;

import rx.Observable;

public class BooleanConditionalSequentialEquals {

	public static void main(String[] args) {

		// Create two equivelent observables...
		Observable<Integer> compareList = Observable.from(DataGenerator.generateBigIntegerList());
		Observable<Integer> compareList2 = Observable.from(DataGenerator.generateBigIntegerList());

		// See if the sequences are equals
		Observable.sequenceEqual(compareList, compareList2)
				// Subscribe to the boolean result.
				.subscribe((b) -> {
					if (b == true) {
						System.out.println("sequenceEqual is true - both sequences match");
					} else {
						System.out.println("sequenceEqual is false - sequences do not match");
					}
				});

		System.out.println();

		// Create two unequal lists...
		compareList = Observable.from(DataGenerator.generateBigIntegerList());
		compareList2 = Observable.from(DataGenerator.generateFibonacciList());

		// See if the sequences are equals
		Observable.sequenceEqual(compareList, compareList2)
				// Subscribe to the boolean result.
				.subscribe((b) -> {
					if (b == true) {
						System.out.println("sequenceEqual is true - both sequences match");
					} else {
						System.out.println("sequenceEqual is false - sequences do not match");
					}
				});

		System.exit(0);
	}
}
