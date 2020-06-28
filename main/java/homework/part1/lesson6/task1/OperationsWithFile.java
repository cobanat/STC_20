package homework.part1.lesson6.task1;

import com.sun.deploy.util.StringUtils;
import homework.part1.lesson6.task1.parser.ParseToStingArray;
import homework.part1.lesson6.task1.reader.ReadFile;
import homework.part1.lesson6.task1.sorter.SortText;
import homework.part1.lesson6.task1.writer.WriteFile;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 15.05.2020
 */
public class OperationsWithFile {
    public static void main(String[] args) {
        ReadFile read = new ReadFile("C:\\test\\beforeSort.txt");
        read.read();
        String text = read.getFileText();

        ParseToStingArray parse = new ParseToStingArray();
        String[] words = parse.toStringArray(text);

        SortText sort = new SortText();
        String sortedText = sort.sortWords(words);

        WriteFile write = new WriteFile("C:\\test\\afterSort.txt");
        write.writeFile(sortedText);
    }
}
