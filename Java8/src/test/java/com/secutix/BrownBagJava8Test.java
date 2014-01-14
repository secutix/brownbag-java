package com.secutix;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class BrownBagJava8Test {

	private String executeWithWrappedSysout(final Runnable block) {
		final PrintStream original = System.out;
		try {
			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			final PrintStream out = new PrintStream(baos) {
				@Override
				public void println(final Object o) {
					super.println(o);
					original.println(o);
				}
			};
			System.setOut(out);
			block.run();
			out.flush();
			return new String(baos.toByteArray());
		} finally {
			System.setOut(original);
		}
	}

	@Test
	public void step1() {
		final String s = executeWithWrappedSysout(BrownBagJava8::step1);
		assertThat(s).contains("2013-10-14T17:33");
	}

	@Test
	public void step2() {
		final String s = executeWithWrappedSysout(BrownBagJava8::step2);
		assertThat(s).contains("2013-10-14T17:33");
	}

	@Test
	public void step3() {
		List<String> senders = BrownBagJava8.step3();

		assertThat(senders).isEqualTo(
				Arrays.asList("@secutix", "@Clusis_Suisse", "@lehub_agence",
						"@amilcarvargas", "@secutix", "@secutix"));
	}

	@Test
	public void step4() {
		List<String> senders = BrownBagJava8.step4();

		assertThat(senders).isEqualTo(
				Arrays.asList("@secutix", "@Clusis_Suisse", "@lehub_agence",
						"@amilcarvargas"));
	}

	@Test
	public void step5() {
		List<String> senders = BrownBagJava8.step5();

		assertThat(senders).isEqualTo(
				Arrays.asList("@Clusis_Suisse", "@amilcarvargas",
						"@lehub_agence", "@secutix"));
	}

	@Test
	public void step6() {
		List<Tweet> lambdaTweets = BrownBagJava8.step6();

		assertThat(
				lambdaTweets.stream().map(Tweet::getId)
						.collect(Collectors.toList())).isEqualTo(
				Arrays.asList(1L, 3L, 4L, 6L));
	}

	@Test
	public void step7() {
		List<Tweet> lambdaTweets = BrownBagJava8.step7();

		assertThat(
				lambdaTweets.stream().map(Tweet::getId)
						.collect(Collectors.toList())).isEqualTo(
				Arrays.asList(4L, 3L, 6L, 1L));
	}

	@Test
	public void step8() {
		final Set<String> hashTags = BrownBagJava8.step8();

		assertThat(hashTags).containsExactly("#lehub", "#smartphone",
				"#audienciaub", "#hospitality", "#secutix", "#clusis",
				"#teatrelliure", "#cloud", "#uefa", "#ticketing");
	}

	@Test
	public void step9() {
		Map<String, List<Tweet>> tweetsBySender = BrownBagJava8.step9();

		assertThat(Arrays.asList(2L)).isEqualTo(
				tweetsBySender.get("@Clusis_Suisse").stream().map(Tweet::getId)
						.collect(Collectors.toList()));
		assertThat(Arrays.asList(4L)).isEqualTo(
				tweetsBySender.get("@amilcarvargas").stream().map(Tweet::getId)
						.collect(Collectors.toList()));
		assertThat(Arrays.asList(3L)).isEqualTo(
				tweetsBySender.get("@lehub_agence").stream().map(Tweet::getId)
						.collect(Collectors.toList()));
		assertThat(Arrays.asList(1L, 5L, 6L)).isEqualTo(
				tweetsBySender.get("@secutix").stream().map(Tweet::getId)
						.collect(Collectors.toList()));
	}

	@Test
	public void step10() {
		final Map<Boolean, List<Tweet>> partition = BrownBagJava8.step10();
		final List<Tweet> withLambda = partition.get(true);
		final List<Tweet> withoutLambda = partition.get(false);

		assertThat(Arrays.asList(1L, 3L, 4L, 6L)).isEqualTo(
				withLambda.stream().map(Tweet::getId)
						.collect(Collectors.toList()));
		assertThat(Arrays.asList(2L, 5L)).isEqualTo(
				withoutLambda.stream().map(Tweet::getId)
						.collect(Collectors.toList()));
	}

	@Test
	public void step11() {
		assertThat(13).isEqualTo(BrownBagJava8.step11());
	}

	@Test
	public void step12() {
		assertThat(2.166d).isEqualTo(BrownBagJava8.step12(), offset(0.01d));
	}

	@Test
	public void step13() {
		assertThat(2.166d).isEqualTo(BrownBagJava8.step13(), offset(0.01d));
	}

	@Test
	public void step14() {
		assertThat(2.166d).isEqualTo(BrownBagJava8.step14(), offset(0.01d));
	}

}