package com.secutix.brownbag.nicolas;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.google.common.collect.ImmutableSetMultimap;

import com.secutix.brownbag.nicolas.LanguageAnalysis;

public class LanguageAnalysisTest {

	// @formatter:off
	private final ImmutableSetMultimap<String, String> peopleLangs
			= ImmutableSetMultimap.<String, String> builder()
				.putAll("Mike", "English")
				.putAll("Robert", "French", "English")
				.putAll("Helmut", "German", "English")
				.putAll("Manu", "French", "German", "English")
				.build();
	// @formatter:on

	private final LanguageAnalysis langAnalysis = new LanguageAnalysis(peopleLangs);

	@Test
	public void languageFrenquencies_should_give_correct_values() {
		assertThat(langAnalysis.languageFrenquency("English")).isEqualTo(4);
		assertThat(langAnalysis.languageFrenquency("French")).isEqualTo(2);
		assertThat(langAnalysis.languageFrenquency("German")).isEqualTo(2);
	}

	@Test
	public void mostSpokenLanguage_should_be_english() {
		assertThat(langAnalysis.mostSpokenLanguage()).isEqualTo("English");
	}

}
