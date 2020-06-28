package homework.part1.lesson6.task1.writer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 18.05.2020
 */
public class WriteFile {

    private String path;

    public WriteFile(String path) {
        this.path = path;
    }

    public void writeFile(String sortedText) {
        try(BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(path)))) {
            writer.write(sortedText);
        } catch (IOException e) {
            /* NOP */
        }
    }
}
