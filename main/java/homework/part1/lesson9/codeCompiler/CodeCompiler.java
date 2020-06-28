package homework.part1.lesson9.codeCompiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.nio.file.Path;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 23.05.2020
 */
public class CodeCompiler {
    public Path compile(Path javaFile) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, javaFile.toFile().getAbsolutePath());
        return javaFile.getParent().resolve("SomeClass.class");
    }
}
