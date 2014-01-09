package com.secutix;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.secutix.Tweet.TWEETS;

public class BrownBagJava8 {

    /**
     * Print all tweets date on the standard output
     */
    public static void step1() {

    }

    /**
     * Same, but without calling directly getDate() ni System.out.println(). 
     * Pass the methods as function arguments.
     */
    public static void step2() {
 
    }

    /**
     * List of tweet senders
     */
    public static List<String> step3() {
       return Collections.emptyList();
    }

    /**
     * List of unique tweet senders
     */
    public static List<String> step4() {
       return Collections.emptyList();
    }

    /**
     * List of unique tweet senders sorted by alphabetical order
     */
    public static List<String> step5() {
       return Collections.emptyList();
    }

    /**
     * Tweets containing the hashtag #secutix
     */
    public static List<Tweet> step6() {
       return Collections.emptyList();
    }

    /**
     * Tweets containing the hashtag #secutix ordered first by sender and then by date
     */
    public static List<Tweet> step7() {
       return Collections.emptyList();
    }

    /**
     * Set of hashtags from all tweets
     */
    public static Set<String> step8() {
       return Collections.emptySet();
    }

    /**
     * Group the tweets by sender
     */
    public static Map<String, List<Tweet>> step9() {
       return Collections.emptyMap();
    }

    /**
     * List tweets containing the hashtag #secutix and tweets not containing the hashtag
     */
    public static Map<Boolean, List<Tweet>> step10() {
       return Collections.emptyMap();
    }

    /**
     * Total number of hashtags used in all tweets.
     * Use {@link java.util.stream.IntStream}.
     */
    public static int step11() {
        return 0;
    }

    /**
     * Average number of hashtags used in tweets.
     * Use {@link java.util.stream.IntStream}.
     */
    public static double step12() {
      return 0d;
    }

    /**
     * Same as step12, but in parallel.
     */
    public static double step13() {
      return 0d;
    }

    /**
     * Same as step12.
     * Use stream.map(...).reduce(...).
     */
    public static double step14() {
      return 0d;
    }
}
