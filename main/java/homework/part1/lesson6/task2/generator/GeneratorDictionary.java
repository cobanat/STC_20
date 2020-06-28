package homework.part1.lesson6.task2.generator;

import java.util.Dictionary;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 18.05.2020
 */
public class GeneratorDictionary implements DictionaryGenerator{

    @Override
    public String[] generateDictionary() {
        RandomTextGenerator word = new RandomTextGenerator();
        int sizeDictionary = ThreadLocalRandom.current().nextInt(1, 1000);
        String[] dictionary = new String[sizeDictionary];
        for(int i = 0; i < dictionary.length; i++) {
            dictionary[i] = word.generateWord();
        }
        return dictionary;
    }
}
