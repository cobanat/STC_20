package homework.part1.lesson6.task2.generator;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 18.05.2020
 */
public class RandomTextGenerator implements TextGenerator{

    private int fileSize;
    private int probability;
    private String[] dictionary;
    private char[] endingSymbols;

    public RandomTextGenerator() {

    }
    public RandomTextGenerator(int fileSize, String[] dictionary, int probability) {
        this.fileSize = fileSize;
        this.dictionary = dictionary;
        this.probability = probability;
        endingSymbols = new char[] {'(', '.', '|', '!', '|', '?', ')', '+', '\"'};
    }

    @Override
    public String generateText() {
        String[] sentences = generateSentences();
        return generateParagraph(sentences);
    }

    public String generateWord() {
        int length = ThreadLocalRandom.current().nextInt(1, 15 + 1);
        return RandomStringUtils.random(length, true, false);
    }

    private String[] generateSentences() {
        int countSentences = ThreadLocalRandom.current().nextInt(1, 20);

        String[] sentences = new String[countSentences];
        for(int i = 0; i < countSentences; i++) {
            sentences[i] = createSentence();
        }
        return sentences;
    }

    private String createSentence() {
        StringBuilder sentence = new StringBuilder();
        int sentenceSize = ThreadLocalRandom.current().nextInt(1, 15);
        if(sentenceSize > 1) {
            for (int i = 0; i < sentenceSize - 1; i++) {
                if (ThreadLocalRandom.current().nextInt(probability) == 0) {
                    int index = ThreadLocalRandom.current().nextInt(dictionary.length - 1);
                    sentence.append(dictionary[index] + " ");
                } else {
                    sentence.append(generateWord() + " ");
                }
            }
        }
        sentence.append(generateWord());
        sentence.append(offerEndSign());
        sentence.append(" ");
        return sentence.toString();
    }

    private String generateParagraph(String[] sentences) {
        StringBuilder paragraph = new StringBuilder();
        paragraph.append(sentences[0]);
        for(int i = 1; i < sentences.length - 1; i++) {
            paragraph.append(sentences[i]);
        }
        paragraph.append(sentences[sentences.length - 1]);
        paragraph.append("\n\r");
        return paragraph.toString();
    }

    private char offerEndSign() {
        int index = ThreadLocalRandom.current().nextInt(endingSymbols.length - 1);
        return endingSymbols[index];
    }

    public String fitToSize(String text) throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();
        builder.append(text);
        while (builder.length() < fileSize) {
            builder.append(generateText());
        }
        byte[] buffer = Arrays.copyOf(builder.toString().getBytes(), fileSize);
        return new String(buffer, "UTF-8");
    }
}
