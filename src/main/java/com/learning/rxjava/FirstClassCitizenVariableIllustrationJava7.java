package com.learning.rxjava;

public class FirstClassCitizenVariableIllustrationJava7 {

	//
	// Java 7 doesn't have the BiFunction type, so we will create our own
	// within our example class.
	//
	public interface BiFunction<U, T, R> {

		public R apply(U a, T b);
	}

	public static void main(String[] args) {

		// ---------------------------------------------------------------------
		// This example illustrates how to create Java 7 style inline code
		// using an anonymous implementation of an interface. Java 8 provides
		// lots of nice syntax, but at the end of the day, it's all mostly
		// syntax candy against single method interfaces.
		// ---------------------------------------------------------------------
		BiFunction<String, String, String> concatFunction = new BiFunction<String, String, String>() {

			@Override
			public String apply(String a, String b) {
				return a + b;
			}
		};
		System.out.println(concatFunction.apply("Hello ", "World 1"));

		// ---------------------------------------------------------------------
		// Example of delegating to a static method using a Java 7 style
		// anonymous inner class. In Java 7, you wind up with this little
		// stub anonymous class that must play router to the static method in
		// the absence of lambda expressions.
		// ---------------------------------------------------------------------
		concatFunction = new BiFunction<String, String, String>() {

			@Override
			public String apply(String a, String b) {
				return concatStrings(a, b);
			}
		};
		System.out.println(concatFunction.apply("Hello ", "World 2"));

		// ---------------------------------------------------------------------
		// This example illustrates how an instance method can be called in a
		// functional way using a delegate anonymous inner class. Note that
		// the instance must be declared "final" so that it is included in the
		// anonymous class' closure.
		// ---------------------------------------------------------------------
		final FirstClassCitizenVariableIllustrationJava7 instance = new FirstClassCitizenVariableIllustrationJava7();
		concatFunction = new BiFunction<String, String, String>() {

			@Override
			public String apply(String a, String b) {
				return instance.concatStrings2(a, b);
			}
		};
		System.out.println(concatFunction.apply("Hello ", "World 3"));
	}

	private static String concatStrings(String a, String b) {
		return a + b;
	}

	/* package */ String concatStrings2(String a, String b) {
		return a + b;
	}
}
