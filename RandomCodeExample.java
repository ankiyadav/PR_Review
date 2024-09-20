import java.util.Random;

public class RandomCodeExample {

    public static void main(String[] args) {
        int[] numbers = generateRandomNumbers(10, 1, 100);
        printArray(numbers);

        int sum = calculateSum(numbers);
        System.out.println("Sum of numbers: " + sum);

        int max = findMaximum(numbers);
        System.out.println("Maximum value: " + findMaximum(numbers));

        int min = findMinimum(numbers);
        System.out.println("Minimum value: " + min);

        boolean isPrime = checkPrime(7);
        System.out.println("Is 7 prime? " + isPrime);
    }

    public static int[] generateRandomNumbers(int count, int min, int max) {
        Random random = new Random();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min;
        }
        return numbers;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int calculateSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static int findMinimum(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int findMaximum(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static boolean checkPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
