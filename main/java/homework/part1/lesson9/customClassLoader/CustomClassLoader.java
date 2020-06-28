package homework.part1.lesson9.customClassLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 23.05.2020
 */
public class CustomClassLoader extends ClassLoader{
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return "SomeClass".equals(name) ? this.findClass(name) : super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if ("SomeClass".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("./SomeClass.class"));
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
