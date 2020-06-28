package homework.part1.lesson6.task2.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 18.05.2020
 */
public class WriteToFile {

    public void write(String path, int numberOfFiles, String text) {
        for(int i = 0; i < numberOfFiles; i++) {
            String fileName = "file_" + i + ".txt";
            Path filePath = Paths.get(path + fileName);
            try(BufferedWriter writer = Files.newBufferedWriter(filePath, Charset.forName("UTF-8"))){
                writer.write(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
