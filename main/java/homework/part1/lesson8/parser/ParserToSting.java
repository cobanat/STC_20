package homework.part1.lesson8.parser;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 22.05.2020
 */
public class ParserToSting {

    public String parse(Class<?> instanceOfClass, Field[] declaredField, Object object) throws IllegalAccessException {
        String serializeText = instanceOfClass.toString() + "\n";

        for (Field fields : declaredField) {
            fields.setAccessible(true);
            serializeText = serializeText + fields.toString() + " " + fields.get(object) + "\n";
        }
        return serializeText;
    }
}
