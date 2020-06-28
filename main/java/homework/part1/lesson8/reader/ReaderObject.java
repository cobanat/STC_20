package homework.part1.lesson8.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 22.05.2020
 */
public class ReaderObject {
    public String[] read(String path) {
        Path filePath = Paths.get(path);
        String[] text = null;
        try(BufferedReader reader = Files.newBufferedReader(filePath, Charset.forName("UTF-8"))){
            text = Files.readAllLines(filePath).stream().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
