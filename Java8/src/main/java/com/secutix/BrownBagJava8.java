package com.secutix;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.secutix.Tweet.TWEETS;

public class BrownBagJava8 {

    /**
     * Print all tweets date on the standard output
     */
    public static void step1() {
        TWEETS
            .forEach(t -> System.out.println(t.getDate()));
    }

    /**
     * Same, but without calling directly getDate() ni System.out.println(). 
     * Pass the methods as function arguments.
     */
    public static void step2() {
        TWEETS
            .stream()
            .map(Tweet::getDate)
            .forEach(System.out::println);
    }

    /**
     * List of tweet senders
     */
    public static List<String> step3() {
        return TWEETS
                .stream()
                .map(Tweet::getDate)
                .collect(Collectors.toList());
    }

    /**
     * List of unique tweet senders
     */
    public static List<String> step4() {
       return TWEETS
                .stream()
                .map(t -> t.getSender())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * List of unique tweet senders sorted by alphabetical order
     */
    public static List<String> step5() {
        return TWEETS
                .stream()
                .map(t -> t.getSender())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Tweets containing the hashtag #secutix
     */
    public static List<Tweet> step6() {
        return TWEETS
                .stream()
                .filter(t -> t.containsHashTag("#secutix"))
                .collect(Collectors.toList());
    }

    /**
     * Tweets containing the hashtag #secutix ordered first by sender and then by date
     */
    public static List<Tweet> step7() {
        return TWEETS
                .stream()
                .filter(t -> t.containsHashTag("#secutix"))
                .sorted(Comparator.comparing(Tweet::getSender)
                                  .thenComparing(Tweet::getDate))
                .collect(Collectors.toList());
    }

    /**
     * Set of hashtags from all tweets
     */
    public static Set<String> step8() {
        return TWEETS
                .stream()
                .flatMap(t -> t.getHashTags().stream())
                .collect(Collectors.toSet());
    }

    /**
     * Group the tweets by sender
     */
    public static Map<String, List<Tweet>> step9() {
        return TWEETS
                .stream()
                .collect(Collectors.groupingBy(Tweet::getSender, Collectors.toList()));
    }

    /**
     * List tweets containing the hashtag #secutix and tweets not containing the hashtag
     */
    public static Map<Boolean, List<Tweet>> step10() {
        return TWEETS
                .stream()
                .collect(Collectors.partitioningBy(t -> t.containsHashTag("#secutix")));
    }

    /**
     * Total number of hashtags used in all tweets.
     * Use {@link java.util.stream.IntStream}.
     */
    public static int step11() {
        return TWEETS
                .stream()
                .mapToInt(t -> t.getHashTags().size())
                .sum();
    }

    /**
     * Average number of hashtags used in tweets.
     * Use {@link java.util.stream.IntStream}.
     */
    public static double step12() {
      return TWEETS
              .stream()
              .mapToInt(t -> t.getHashTags().size())
              .average()
              .orElse(0L);
    }

    /**
     * Same as step12, but in parallel.
     */
    public static double step13() {
      return TWEETS
              .stream()
              .parallel()
              .mapToInt(t -> t.getHashTags().size())
              .average()
              .orElse(0L);
    }

    /**
     * Same as step12.
     * Use stream.mapToInt(...).reduce(...).
     */
    public static double step14() {
      final int nbHashTags = TWEETS
                .stream()
                .mapToInt(t -> t.getHashTags().size())
                .reduce(Integer::sum)
                .orElse(0);
      return ((double)nbHashTags) / TWEETS.size();
    }
}
