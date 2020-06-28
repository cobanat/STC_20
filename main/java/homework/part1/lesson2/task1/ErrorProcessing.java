package homework.part1.lesson2.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that triggers the generation of errors
 *
 * @author Nail Zinnurov

 * */
public class ErrorProcessing {

    public static void main(String[] args) {
        GenerateErrors errors = new GenerateErrors();

        errors.NullPointerExceptionExample();
        errors.ArrayIndexOutOfBoundsExceptionExample();
        errors.FileNotFoundException();

        List<String> list = new ArrayList<>();
        list.add("lol");
    }

}
