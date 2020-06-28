package homework.part1.lesson6.task1.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 18.05.2020
 */
public class ReadFile {
    private String path;
    private String fileText;

    public ReadFile(String path) {
        this.path = path;
    }

    public void read() {
        fileText = null;
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path)))) {
            String line;
            StringBuilder text = new StringBuilder();
            while((line = reader.readLine()) != null) {
                text.append((line));
            }
            fileText = text.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileText() {
        return fileText;
    }
}
