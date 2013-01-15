package com.secutix.brownbag.nicolas;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

public class ProgLang {

	private static final ImmutableSet<String> progLangs = ImmutableSet.of("Java", "Groovy", "Jython", "Python", "Ruby",
			"JRuby", "Perl", "C#", "Scala", "Clojure", "PHP", "Javascript", "Coffeescript");

	private static final Predicate<String> startWithJ = new Predicate<String>() {
		public boolean apply(final String lang) {
			return lang.startsWith("J");
		}
	};

	public static ImmutableSet<String> getJLangs() {
		return FluentIterable.from(progLangs).filter(startWithJ).toSet();
	}

	private static final Function<Object, String> toUpperCase = new Function<Object, String>() {
		public String apply(final Object o) {
			return o.toString().toUpperCase();
		}
	};

	public static ImmutableSet<String> getUpperCaseLangs() {
		return FluentIterable.from(progLangs).transform(toUpperCase).toSet();
	}

	private static final Predicate<String> longerThan5Chars = new Predicate<String>() {
		public boolean apply(String input) {
			return input.length() > 5;
		}
	};

	public static Boolean allLangsLongerThan5Chars() {
		return Boolean.valueOf(Iterables.all(progLangs, longerThan5Chars));
	}

	public static Boolean anyLangsLongerThan5Chars() {
		return Boolean.valueOf(Iterables.any(progLangs, longerThan5Chars));
	}
}
