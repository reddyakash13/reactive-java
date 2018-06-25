package com.learning.rxjava;

public class FirstClassCitizenParameterIllustrationJava7 {

	public static interface Function<T, R> {

		public R apply(T t);
	}

	public static void main(String[] args) {

		// The concatAndTransform call illustrates the lambda-less way to
		// accomplish "function passing" in Java 7. This example shows
		// inline definition of the function while the next example shows the
		// same using...
		System.out.println(concatAndTransform("Hello ", "World", new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		}));

		// ...a variable.
		Function<String, String> transformToLower = new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t.toLowerCase();
			}
		};
		System.out.println(concatAndTransform("Hello ", "World", transformToLower));
	}

	public static String concatAndTransform(String a, String b, Function<String, String> stringTransform) {

		// NOTE: Please see the "Optional" class in Java 8...it would be more
		// correct that what I'm doing here. I just didn't want to confuse
		// the point about functions as parameters.
		if (stringTransform != null) {
			a = stringTransform.apply(a);
			b = stringTransform.apply(b);
		}

		return a + b;
	}
}
