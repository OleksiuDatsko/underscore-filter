package ua.lviv.iot.algo.part1;

import lombok.AllArgsConstructor;
import ua.lviv.iot.algo.part1.reader.Reader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class UnderscoreFilter {
    private String text;
    private int maxWordLength;

    UnderscoreFilter(){
        text = Reader.readTextFromConsole();
        maxWordLength = Reader.readMaximumWordLength();
    }

    private List<String> wordsWithUnderscores(){
        Pattern pattern = Pattern.compile("([a-zA-Z]*_+[a-zA-Z]*)+");
        Matcher matcher = pattern.matcher(text);
        List<String> result = new ArrayList<String>();
        while(matcher.find()){
            result.add(matcher.group());
        }
        return result;
    }


    public String SortWordsWithUnderscores(){
        List<String> wordsWithUnderscore = wordsWithUnderscores();
        List<String> wordsWithUnderscoreShort = new LinkedList<>();
        for(var wordWithUnderscore: wordsWithUnderscore){
            if(wordWithUnderscore.replace("_","").length() <= maxWordLength){
                wordsWithUnderscoreShort.add(wordWithUnderscore);
            }
        }
        wordsWithUnderscoreShort.sort(Comparator.comparing(word -> word));
        return wordsWithUnderscoreShort.toString();
    }

    public static void main(String[] args) {
        UnderscoreFilter text = new UnderscoreFilter("Lorem ipsu_m dolor sit_ amet, consectetur adipiscing elit." +
                " Etiam nunc tortor, lacinia ut leo at, viver_ra sagittis ante." +
                " Nunc la_oreet nibh mauris, si_t amet laoreet risus accumsan id." +
                " Cras pulvinar at sapien ac suscipit. Mo_rbi non tempus odio, vel vestibulum elit." +
                " Aliquam erat v_o_lutpat. In in libero tincidunt, lobortis leo eg_et, fermentum est." +
                " Donec _sodales nibh at lorem tincidunt, at venenatis urna consequat." +
                " Pellentesque _placerat qu_am in molestie fringilla." +
                " Nullam dictum sit amet sapien in vehicula.", 10);
//        UnderscoreFilter text2 = new UnderscoreFilter();
        System.out.println(text.SortWordsWithUnderscores());
    }
}


