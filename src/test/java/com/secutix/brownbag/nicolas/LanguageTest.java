package com.secutix.brownbag.nicolas;

import static com.secutix.brownbag.nicolas.Language.getLangCode;
import static com.secutix.brownbag.nicolas.Language.getLangName;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class LanguageTest {

	@Test
	public void getLangCode_should_return_languages_code() {
		final String en = getLangCode("English");
		assertThat(en).isEqualTo("en");
		final String fr = getLangCode("French");
		assertThat(fr).isEqualTo("fr");
		final String de = getLangCode("German");
		assertThat(de).isEqualTo("de");
	}

	@Test(expected = NullPointerException.class)
	public void getLangCode_should_not_accept_null_param() {
		getLangCode(null);
	}

	@Test
	public void getLangName_should_return_languages_name() {
		final String en = getLangName("en");
		assertThat(en).isEqualTo("English");
		final String fr = getLangName("fr");
		assertThat(fr).isEqualTo("French");
		final String de = getLangName("de");
		assertThat(de).isEqualTo("German");
	}
}
