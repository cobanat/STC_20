package homework.part1.lesson2.task1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *  Error generating class
 *
 * @author Nail
 *

 * */
public class GenerateErrors {
    private Logger log = Logger.getLogger(this.getClass().getName());

    private String hello = "Hello, World!";
    private char[] charsHelloText = hello.toCharArray();

    public void NullPointerExceptionExample() {
        try {
            hello = null;
            hello.length();
        } catch (NullPointerException e) {
            log.log(Level.WARNING, "Empty string!", e);
        }
    }

    public void ArrayIndexOutOfBoundsExceptionExample() {

        try {
            System.out.println(charsHelloText[charsHelloText.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            log.log(Level.WARNING, "Array limits exceeded", e);
        }
    }

    public void FileNotFoundException() {
        try {
            File file = new File("Nonexistent File");
            Scanner sc = new Scanner(file);

        } catch (FileNotFoundException e) {
            log.log(Level.WARNING,"The file does not exist", e);
        }
    }
}
