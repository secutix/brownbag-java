package com.secutix.brownbag.nicolas;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

import com.secutix.brownbag.nicolas.ProgLang;

public class ProgLangTest {

	@Test
	public void jlangs_should_returns_only_langs_with_J() {
		final ImmutableSet<String> jLangs = ProgLang.getJLangs();
		assertThat(jLangs).isNotNull();
		assertThat(jLangs).containsOnly("Java", "Jython", "JRuby", "Javascript");
	}

	@Test
	public void upperCaseLangs_should_returns_langs_in_upperCase_format() {
		final ImmutableSet<String> jLangs = ProgLang.getUpperCaseLangs();
		assertThat(jLangs).isNotNull();
		assertThat(jLangs).containsOnly("JAVA", "GROOVY", "JYTHON", "PYTHON", "RUBY", "JRUBY", "PERL", "C#", "SCALA",
				"CLOJURE", "PHP", "JAVASCRIPT", "COFFEESCRIPT");
	}

	@Test
	public void allLangsLongerThan5Chars_should_be_false() {
		assertThat(ProgLang.allLangsLongerThan5Chars()).isFalse();
	}

	@Test
	public void anyLangsLongerThan5Chars_should_be_true() {
		assertThat(ProgLang.anyLangsLongerThan5Chars()).isTrue();
	}

}
