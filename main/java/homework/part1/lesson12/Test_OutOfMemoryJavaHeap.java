package homework.part1.lesson12;

import javassist.CannotCompileException;
import javassist.ClassPool;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 31.05.2020
 */
public class Test_OutOfMemoryJavaHeap {
    private static final int LOOP_COUNT = 1_999_999_999;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        boolean isPrimeLength = true;

        for (int i = 0; i < LOOP_COUNT; i++) {
            String str = randomString();
            list.add(str);
            for(int j = 2; j < i; j++) {
                if(str.length() % j == 0) {
                    isPrimeLength = false;
                    break;
                }
            }
            if(isPrimeLength) {
                list.remove(str);
            }
        }
    }

    private static String randomString() {
        int length = ThreadLocalRandom.current().nextInt(100, 10000);
        return RandomStringUtils.random(length, true, false);
    }
}
