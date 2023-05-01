package ua.lviv.iot.algo.part1;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnderscoreFilter {
    public static final Pattern PATTERN_WORDS_WITH_UNDERSCORE = Pattern.compile("([a-zA-Z]*_+[a-zA-Z]*)+");

    private List<String> wordsWithUnderscores(String text) {
        if (text == null) {
            return null;
        }
        Matcher matcher = PATTERN_WORDS_WITH_UNDERSCORE.matcher(text);
        List<String> result = new LinkedList<String>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }


    public String sortWordsWithUnderscores(String text, int maxWordLength) {
        if (text == null || text.isBlank()){
            return "null";
        }
        List<String> wordsWithUnderscore = wordsWithUnderscores(text);
        if (wordsWithUnderscore == null) {
            return null;
        }
        List<String> wordsWithUnderscoreShort = new ArrayList<>();
        for (var wordWithUnderscore : wordsWithUnderscore) {
            if (wordWithUnderscore.replace("_", "").length() <= maxWordLength) {
                wordsWithUnderscoreShort.add(wordWithUnderscore);
            }
        }
        wordsWithUnderscoreShort
                .sort(Comparator.comparing(word -> word.toLowerCase()
                        .replace("_", "")));
        return wordsWithUnderscoreShort.toString();
    }
}


