package homework.part1.lesson9.codeReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 23.05.2020
 */
public class CodeReader {
    public String readCode() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path sourcePatch = Paths.get(".\\SomeClass.java");
        StringBuilder builder =new StringBuilder();
        builder.append("public class SomeClass {\n");
        builder.append("\tpublic void doWork() {\n");

        while (true) {
            String line = reader.readLine();
            if (line == null || line.equals("")) break;
            builder.append("\t\t" + line + "\n");
        }
        builder.append("\t}\n");
        builder.append("}");

        return builder.toString();
    }
}
