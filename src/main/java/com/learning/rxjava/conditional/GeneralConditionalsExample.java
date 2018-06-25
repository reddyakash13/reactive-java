package com.learning.rxjava.conditional;

import com.learning.rxjava.util.DataGenerator;

import rx.Observable;

public class GeneralConditionalsExample {

	public static void main(String[] args) {

		// defaultIfEmpty example - We create an empty observable
		// and then apply "defaultIfEmpty" and set the default to "Hello World".
		// Since the observable is empty, "Hello World" will be emitted as
		// the only event.
		Observable.empty().defaultIfEmpty("Hello World").subscribe((s) -> {
			System.out.println(s);
		});

		System.out.println();

		// defaultIfEmpty example 2 - We create an non-empty observable
		// and then apply "defaultIfEmpty" and set the default to "Hello World".
		// Since the observable is not empty, the list items will be emitted.
		Observable.from(DataGenerator.generateGreekAlphabet()).defaultIfEmpty("Hello World").first() // we
																										// just
																										// want
																										// to
																										// show
																										// that
																										// it
																										// isn't
																										// Hello
																										// World...
				.subscribe((s) -> {
					System.out.println(s);
				});

		System.out.println();

		Observable.from(DataGenerator.generateFibonacciList()).skipWhile((i) -> {
			return i < 8;
		}).subscribe((i) -> {
			System.out.println(i);
		});

		System.out.println();

		Observable.from(DataGenerator.generateFibonacciList()).takeWhile((i) -> {
			return i < 8;
		}).subscribe((i) -> {
			System.out.println(i);
		});

		System.out.println();

		Observable.from(DataGenerator.generateFibonacciList()).takeWhileWithIndex((i, index) -> {
			return index < 3;
		}).subscribe((i) -> {
			System.out.println(i);
		});

		System.out.println();

		System.exit(0);

	}

}
