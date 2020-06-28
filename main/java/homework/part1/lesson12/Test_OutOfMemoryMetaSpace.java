package homework.part1.lesson12;

import javassist.CannotCompileException;
import javassist.ClassPool;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 31.05.2020
 */
public class Test_OutOfMemoryMetaSpace {
    static ClassPool classPool = ClassPool.getDefault();
    public static void main(String[] args) throws CannotCompileException {
        for (int i = 0; i < 2000000000; i++) {
            Class c = classPool.makeClass("com.saket.demo.Metaspace" + i).toClass();
        }
    }
}
