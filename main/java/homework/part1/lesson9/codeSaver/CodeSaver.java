package homework.part1.lesson9.codeSaver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 23.05.2020
 */
public class CodeSaver {
    public Path save(String code) throws IOException {
        Path javaFile = Paths.get(".\\SomeClass.java");
        Files.write(javaFile, code.getBytes(UTF_8));
        return javaFile;
    }
}
