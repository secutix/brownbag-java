package com.secutix;

import static com.secutix.Language.getLangCode;
import static com.secutix.Language.getLangName;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class LanguageTest {

	@Test
	public void getLangCode_should_return_languages_code() {
		final String en = getLangCode("English");
		assertThat(en).equals("en");
		final String fr = getLangCode("French");
		assertThat(fr).equals("fr");
		final String de = getLangCode("German");
		assertThat(de).equals("de");
	}

	@Test(expected = NullPointerException.class)
	public void getLangCode_should_not_accept_null_param() {
		getLangCode(null);
	}

	@Test
	public void getLangName_should_return_languages_name() {
		final String en = getLangName("en");
		assertThat(en).equals("English");
		final String fr = getLangName("fr");
		assertThat(fr).equals("French");
		final String de = getLangName("de");
		assertThat(de).equals("German");
	}
}
