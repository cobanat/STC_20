package homework.part1.lesson2.task2;
/**
 * A class that calculates the square root of a number,
 * and if the square root is an integer, prints to the console.
 *
 * @author Nail
 * */

public class IntegerSquare {

    public void squareRootCalculation(int[] num) throws NegativeNumberException {
        int squareRoot;
        for (int i : num) {
            if(i < 0) {
                throw new NegativeNumberException("This number is less than zero.", i);
            }

            squareRoot = (int) Math.sqrt(i);
            if(squareRoot * squareRoot == i) System.out.print(i + " ");
        }
    }
}
