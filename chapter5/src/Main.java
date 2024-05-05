import ch.five.T1PerfectHashFunction;
import ch.five.T2HashCode;
import ch.five.T3ModularHash;
import ch.five.T4SeparateChainingHashTable;

import java.util.Scanner;
import java.util.Date;


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
                System.out.println("Hash word is ABC\n");
                T1PerfectHashFunction.findPerfectHashFunction("ABC");
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

    static void task2() {
        T2HashCode.Point2D point = new T2HashCode.Point2D(3.5, 4.2);
        T2HashCode.Interval interval = new T2HashCode.Interval(2.0, 5.0);
        T2HashCode.Interval2D interval2D = new T2HashCode.Interval2D(new T2HashCode.Interval(1.0, 2.0),
                new T2HashCode.Interval(3.0, 4.0));
        T2HashCode.CustomDate customDate = new T2HashCode.CustomDate(new Date());

        System.out.println("hashCode for Point2D: " + point.hashCode());
        System.out.println("hashCode for Interval: " + interval.hashCode());
        System.out.println("hashCode for Interval2D: " + interval2D.hashCode());
        System.out.println("hashCode for CustomDate: " + customDate.hashCode());
    }

    static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String str1 = scanner.next();
        System.out.println("Enter the second string: ");
        String str2 = scanner.next();

        int hashCode1 = T3ModularHash.modularHash(str1);
        int hashCode2 = T3ModularHash.modularHash(str2);

        System.out.println("Hash code for string \"" + str1 + "\": " + hashCode1);
        System.out.println("Hash code for string \"" + str2 + "\": " + hashCode2);

        if (hashCode1 == hashCode2) {
            System.out.println("Collision.");
        } else {
            System.out.println("Hash codes are different.");
        }
    }

    static void task4() {
        int[] sizes = {1000, 10000, 100000, 1000000};

        for (int N : sizes) {
            T4SeparateChainingHashTable hashTable = new T4SeparateChainingHashTable(N / 100);
            for (int i = 0; i < N; i++) {
                hashTable.put(i);
            }
            System.out.println("For N = " + N + ":");
            System.out.println("Length of the shortest list: " + hashTable.getMinListLength());
            System.out.println("Length of the longest list: " + hashTable.getMaxListLength());
            System.out.println();
        }
    }
}