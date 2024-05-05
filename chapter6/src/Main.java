import ch.six.T1MsdSort;
import ch.six.T2ThreeWayQuickSort;
import ch.six.T3SublinearSort;
import ch.six.T4InPlaceRadixSort;

import java.util.Arrays;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] strings = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        T1MsdSort.sort(strings);

        System.out.println("\nSorted strings:");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of arrays: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] arrays = new int[n][];

        System.out.println("Enter the arrays (each on a new line):");
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] elements = input.split("\\s+");
            arrays[i] = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                arrays[i][j] = Integer.parseInt(elements[j]);
            }
        }

        T2ThreeWayQuickSort.quickSortArrays(arrays, 0, arrays.length - 1);

        System.out.println("\nSorted arrays:");
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }

    static void task3() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        T3SublinearSort.sublinearSort(array);

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(array));
    }

    static void task4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        T4InPlaceRadixSort.inPlaceRadixSort(array);

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(array));
    }
}