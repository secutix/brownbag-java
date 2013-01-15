package com.secutix.brownbag.nicolas;

import com.google.common.collect.ImmutableBiMap;

public class Language {

	private static ImmutableBiMap<String, String> LANGS = ImmutableBiMap.of("French", "fr", "English", "en", "German",
			"de");

	/**
	 * @return The language code
	 */
	public static String getLangCode(final String langName) {
		return LANGS.get(langName);
	}

	/**
	 * @return The language name
	 */
	public static String getLangName(final String langCode) {
		return LANGS.inverse().get(langCode);
	}
}
