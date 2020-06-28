package homework.part1.lesson3;

import homework.part1.lesson3.typesBox.MathBox;

public class Start {
    public static void main(String[] args) {

        Double[] number = new Double[]{1.0, 2.0, 3.0, 4.0, 5.0, 5.0, 7.0, 8.0, 9.0, 10.0};
        MathBox mathBox = new MathBox(number);
        mathBox.addObject(11.0);
        mathBox.dump();
        mathBox.deleteObject(11.0);
        System.out.println(mathBox.summator());
        mathBox.splitter(2);
        mathBox.dump();
        System.out.println(mathBox.toString());
        System.out.println(mathBox.hashCode());


    }
}
