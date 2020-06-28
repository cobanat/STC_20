package homework.part1.lesson6.task2.fileCreator;

import homework.part1.lesson6.task2.generator.RandomTextGenerator;
import homework.part1.lesson6.task2.generator.TextGenerator;
import homework.part1.lesson6.task2.writer.WriteToFile;

import java.io.UnsupportedEncodingException;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 16.05.2020
 */
public class FileCreatorWithRandomText {

    public void getFiles(String path, int numberOfFiles, int fileSize, String[] words, int probability) throws UnsupportedEncodingException {
        TextGenerator randomText = new RandomTextGenerator(fileSize, words, probability);
        String text = randomText.generateText();
        if(text.length() != fileSize) {
            text = ((RandomTextGenerator) randomText).fitToSize(text);
        }
        WriteToFile writeText = new WriteToFile();
        writeText.write(path, numberOfFiles, text);
    }

}
