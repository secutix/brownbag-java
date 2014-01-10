package com.secutix;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public final class Tweet {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = 
                                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public static final List<Tweet> TWEETS = 
        Collections.unmodifiableList(
             Arrays.asList(new Tweet(1L,
                                     "@secutix",
                                     "Record attendance at #teatrelliure for the 2012-2013 season with #SecuTix - http://bit.ly/GUMZTi",
                                     date("14/10/2013 17:33"),
                                     9),
                           new Tweet(2L,
                                     "@Clusis_Suisse",
                                     "Aujourd'hui à Lausanne #smartphone, Secutix, #cloud au #Clusis  http://www.clusis.ch",
                                     date("08/10/2013 03:03"),
                                     0),
                           new Tweet(3L,
                                     "@lehub_agence",
                                     "Le hub et #secutix seront au @BIS_Nantes : Relations publiques 2.0 : une révolution culturelle à la portée de tous. http://bit.ly/1lvKkz8 ",
                                     date("06/01/2014 16:17"),
                                     0),
                           new Tweet(4L,
                                     "@amilcarvargas",
                                     "Jesús Cobo from #SecuTix works in many european capitals managing their tickets selling. http://www.secutix.com/en  #audienciaUB",
                                     date("27/09/2013 14:00"),
                                     1),
                           new Tweet(5L,
                                     "@secutix",
                                     "A vos agendas! L’atelier relations publiques 2.0 c’est avec #lehub_agence et SecuTix aux BIS le 22 janvier prochain! http://bit.ly/1dhDETj ",
                                     date("09/01/2014 15:42"),
                                     6),
                           new Tweet(6L,
                                     "@secutix",
                                     "We are proud to announce that #SecuTix is the new #UEFA s #ticketing & #hospitality partner ! http://bit.ly/1fPYRjE ",
                                     date("13/09/2013 10:04"),
                                     20))); 

    private static final LocalDateTime date(String s) {
        return LocalDateTime.parse(s, DATE_TIME_FORMATTER);
    }  

    private final Long id;
    private final String sender;
    private final String text;
    private final LocalDateTime date;
    private final int retweetCount;

    public Tweet(Long id, String sender, String text, LocalDateTime date, int retweetCount) {
        this.id = id;
        this.sender = sender;
        this.text = text;
        this.date = date;
        this.retweetCount = retweetCount;
    }

    public Long getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    /**
     * Extracts the hash tags from the tweet
     * @return a set of hash tags, with the leading <code>#</code>
     */
    public Set<String> getHashTags() {
        return Arrays
                .stream(text.toLowerCase().split("[\\s.,;:!?-_]"))
                .filter(s -> s.startsWith("#"))
                .collect(Collectors.toSet());
    }

    /**
     * Tests if the given hash tag is contained into the tweet
     * @param hashTag a hash tag, with a leading <code>#</code>
     * @return
     */
    public boolean containsHashTag(final String hashTag) {
        return text.toLowerCase().contains(hashTag);
    }

    @Override
    public String toString() {
        return String.format("Tweet{id=%d, sender='%s', text='%s',date=%s, retweetCount=%d}",
            id, sender, text, date.format(DATE_TIME_FORMATTER), retweetCount);
    }
}
