package homework.part1.lesson6.task2.test;


import homework.part1.lesson6.task2.fileCreator.FileCreatorWithRandomText;
import homework.part1.lesson6.task2.generator.GeneratorDictionary;

import java.io.UnsupportedEncodingException;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 18.05.2020
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        FileCreatorWithRandomText test = new FileCreatorWithRandomText();
        GeneratorDictionary dictionary = new GeneratorDictionary();
        String[] words  = dictionary.generateDictionary();
        test.getFiles("C:\\test\\", 5, 1000, words, 25);
    }
}
