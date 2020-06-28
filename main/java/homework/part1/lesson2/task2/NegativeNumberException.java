package homework.part1.lesson2.task2;

public class NegativeNumberException extends Exception {

    private int number;

    public int getNumber(){
        return number;
    }
    public NegativeNumberException(String message, int num) {

        super(message);
        number = num;
    }
}
