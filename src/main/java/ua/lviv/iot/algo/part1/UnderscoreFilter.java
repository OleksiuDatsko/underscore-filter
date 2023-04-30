package ua.lviv.iot.algo.part1;

import lombok.AllArgsConstructor;
import ua.lviv.iot.algo.part1.reader.Reader;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;

@AllArgsConstructor
public class UnderscoreFilter {
    private String text;
    private int maxWordLength;

    UnderscoreFilter() {
        Reader reader = new Reader();
        text = reader.readTextFromConsole();
        try {
            maxWordLength = reader.readMaximumWordLength();
        } catch (InputMismatchException e) {
            maxWordLength = -1;
        }
    }

    private List<String> wordsWithUnderscores() {
        Pattern pattern = Pattern.compile("([a-zA-Z]*_+[a-zA-Z]*)+");
        Matcher matcher = pattern.matcher(text);
        List<String> result = new ArrayList<String>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }


    public String sortWordsWithUnderscores() {
        List<String> wordsWithUnderscore = wordsWithUnderscores();
        List<String> wordsWithUnderscoreShort = new ArrayList<>();
        for (var wordWithUnderscore : wordsWithUnderscore) {
            if (wordWithUnderscore.replace("_", "").length() <= maxWordLength) {
                wordsWithUnderscoreShort.add(wordWithUnderscore);
            }
        }
        wordsWithUnderscoreShort
                .sort(Comparator.comparing(word -> word.toLowerCase().replace("_", "")));
        return wordsWithUnderscoreShort.toString();
    }
}


