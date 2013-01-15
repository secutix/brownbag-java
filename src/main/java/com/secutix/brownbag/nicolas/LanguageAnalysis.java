package com.secutix.brownbag.nicolas;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Ordering;

public class LanguageAnalysis {

	private final Multiset<String> languageFrequencies;

	public LanguageAnalysis(final ImmutableSetMultimap<String, String> peopleLangs) {
		languageFrequencies = ImmutableMultiset.copyOf(peopleLangs.values());
	}

	public int languageFrenquency(final String lang) {
		return languageFrequencies.count(lang);
	}

	public String mostSpokenLanguage() {
		final Ordering<Entry<String>> frenquencyOrder = new Ordering<Entry<String>>() {
			@Override
			public int compare(final Entry<String> left, final Entry<String> right) {
				return Integer.valueOf(left.getCount()).compareTo(Integer.valueOf(right.getCount()));
			}
		};
		return frenquencyOrder.max(languageFrequencies.entrySet()).getElement();
	}
}
