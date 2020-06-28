package homework.part1.lesson9;

import homework.part1.lesson9.codeCompiler.CodeCompiler;
import homework.part1.lesson9.codeReader.CodeReader;
import homework.part1.lesson9.codeSaver.CodeSaver;
import homework.part1.lesson9.customClassLoader.CustomClassLoader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 23.05.2020
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String path = ".\\SomeClass.java";
        CodeReader reader = new CodeReader();
        String code = reader.readCode();
        CodeSaver saver = new CodeSaver();
        Path javaFile = saver.save(code);
        CodeCompiler compiler = new CodeCompiler();
        compiler.compile(javaFile);

        SomeClass classic = new SomeClass();
        classic.doWork();

        ClassLoader loader = new CustomClassLoader();
        Class<?> clazz = loader.loadClass("SomeClass");
        clazz.getMethod("doWork").invoke(clazz.newInstance());
    }
}