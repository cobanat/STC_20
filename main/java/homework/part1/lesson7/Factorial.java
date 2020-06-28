package homework.part1.lesson7;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 11.05.2020
 */
public class Factorial {
    public static void main(String[] args) {

        int[] numbers = generateRandomNumbers(20);
        Arrays.sort(numbers);
        for(int num : numbers) {
            System.out.println("Number: " + num + " Factorial: " + parallelFactorial(num));
        }

    //TODO: Реализовать с сохранением (Map) Cuncurrent
    }
    public static BigInteger parallelFactorial(int n) {
        if(n < 2) {
            return BigInteger.valueOf(1);
        }
        return IntStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply).get();
    }

    private static int[] generateRandomNumbers(int arraySize) {
        Random randomNumber = new Random();
        int[] randomNumbers = new int[arraySize];
        for(int i = 0; i < arraySize; i++) {
            randomNumbers[i] = randomNumber.nextInt(20);
        }
        return randomNumbers;
    }
}


