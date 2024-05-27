import cheight.T1CyclicPermutation;
import cheight.T4KnutMorrisPratt;

import java.security.SecureRandom;
import java.util.Scanner;
import static cheight.T2TwoDImSearch.contains2DPattern;
import static cheight.T3BinaryStringCount.countOccurrences;


public class Main {
    public static void main(String[] args) {
        int task;
        int replay = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            while (true) {
                System.out.println("Enter the number of task(from 1 to 4): ");
                try {
                    task = Integer.parseInt(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            if (task == 1) {
                task1();
            } else if (task == 2) {
                task2();
            } else if (task == 3) {
                task3();
            } else if (task == 4) {
                task4();
            } else {
                System.out.println("Invalid input");
                replay = 1;
            }
            System.out.println("Enter 0 to end or another symbol to continue");
            replay = scanner.nextInt();
        } while (replay != 0);
    }

    static void task1() {
        String s1 = "пальто";
        String s2 = "топаль";
        System.out.println(T1CyclicPermutation.isCyclicPermutation(s1, s2)); // true

        s1 = "абвгд";
        s2 = "бвгда";
        System.out.println(T1CyclicPermutation.isCyclicPermutation(s1, s2)); // true

        s1 = "123456";
        s2 = "234561";
        System.out.println(T1CyclicPermutation.isCyclicPermutation(s1, s2)); // true

        s1 = "abc";
        s2 = "def";
        System.out.println(T1CyclicPermutation.isCyclicPermutation(s1, s2)); // false
    }


    static void task2() {
        char[][] text = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        char[][] pattern = {
                {'f', 'g'},
                {'j', 'k'}
        };

        System.out.println(contains2DPattern(text, pattern)); // true

        pattern = new char[][]{
                {'a', 'b'},
                {'e', 'f'}
        };

        System.out.println(contains2DPattern(text, pattern)); // true

        pattern = new char[][]{
                {'b', 'c'},
                {'f', 'h', 'h'}
        };

        System.out.println(contains2DPattern(text, pattern)); // false
    }

    static void task3() {
        int N = 100; // string length
        int M = 3;   // amount of last bits

        String binaryString = generateRandomBinaryString(N);
        System.out.println("Generated binary string: " + binaryString);

        int count = countOccurrences(binaryString, M);
        System.out.println("Number of occurrences of the last " + M + " bits: " + count);
    }

    static void task4() {
        int M = 5; // length of example
        int N = 100; // text length
        int T = 1000; // amount of repeats

        long totalComparisons = 0;

        for (int i = 0; i < T; i++) {
            String pattern = generateRandomBinaryString(M);
            String text = generateRandomBinaryString(N);
            T4KnutMorrisPratt kmp = new T4KnutMorrisPratt(pattern);
            kmp.search(text);
            totalComparisons += kmp.getComparisons();
        }

        double averageComparisons = (double) totalComparisons / T;
        System.out.println("Average number of comparisons: " + averageComparisons);
    }

    public static String generateRandomBinaryString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(2));
        }
        return sb.toString();
    }
}