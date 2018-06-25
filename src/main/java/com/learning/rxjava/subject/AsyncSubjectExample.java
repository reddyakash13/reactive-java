package com.learning.rxjava.subject;

import com.learning.rxjava.util.DataGenerator;

import rx.Observable;
import rx.subjects.AsyncSubject;

public class AsyncSubjectExample {

	public static void main(String[] args) {

		// Create an AsyncSubject using its factory method
		AsyncSubject<String> subject = AsyncSubject.create();

		// We want to subscribe to this subject
		subject.subscribe((letter) -> {
			System.out.println(letter);
		});

		// Next we create an observable out of the greek alphabet...
		Observable.from(DataGenerator.generateGreekAlphabet()).subscribe((letter) -> {
			// ...for each letter, we will emit an event to the subject
			subject.onNext(letter);
		}, (t) -> {
			subject.onError(t);
		},
				// ...once complete...we tell the subject
				() -> {
					subject.onCompleted();
				});

		// We will only see "Omega" because an AsyncSubject emits only the
		// last event published to it. This is useful for having a subject
		// that goes through multiple states but only the final state is
		// interesting.

		System.exit(0);
	}
}
