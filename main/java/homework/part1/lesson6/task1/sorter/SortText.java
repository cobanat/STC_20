package homework.part1.lesson6.task1.sorter;

import com.sun.deploy.util.StringUtils;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 18.05.2020
 */
public class SortText {
    
    public String sortWords(String[] words) {
        if(words.length == 0) {
            return null;
        }
        Set<String> sortedWords = new TreeSet<>(String::compareToIgnoreCase);
        for (String str : words) {
            sortedWords.add(str);
        }
        return StringUtils.join(sortedWords, " ");
    }
}
