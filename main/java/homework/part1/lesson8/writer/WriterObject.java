package homework.part1.lesson8.writer;

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
public class WriterObject {

    public void write(String serializeText, String path) {
        Path filePath = Paths.get(path);
        try(BufferedWriter writer = Files.newBufferedWriter(filePath, Charset.forName("UTF-8"))){
            writer.write(serializeText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
