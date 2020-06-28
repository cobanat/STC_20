package homework.part1.lesson2.task2;
/**
 * The class whose methods fill an integer array with random numbers from -3 to 100.
 *
 * @author Nail
 * */
public class Start {

    public static void main(String[] args) throws NegativeNumberException {
        int[] num = new int[100];
        IntegerSquare square = new IntegerSquare();

        generateRandomNumbers(num);
        square.squareRootCalculation(num);

    }

    private static void generateRandomNumbers(int[] num) {
        for(int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 100) - 3;
        }
    }
}
