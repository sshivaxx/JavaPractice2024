import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

import ch.two.T1Vector;
import ch.two.T2Domain;
import ch.two.T3StableSortWrapper;

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
                } catch (NumberFormatException _) {}
            }
            if (task == 1) {
                task1();
            } else if (task == 2) {
                task2();
            } else if (task == 3) {
                task3();
            } else {
                System.out.println("Invalid input");
                replay = 1;
            }
            System.out.println("Enter 0 to end or another symbol to continue");
            replay = scanner.nextInt();
        } while (replay != 0);
    }

    static void task1(){
        T1Vector[] vectors = {
                new T1Vector(3, 1, 4, 2),
                new T1Vector(2, 4, 1, 3),
                new T1Vector(2, 2, 3, 1),
                new T1Vector(1, 2, 3, 4)
        };
        System.out.println("Before sorting: ");
        for (T1Vector vector : vectors) {
            System.out.println(vector);
        }
        Arrays.sort(vectors);
        System.out.println("After sorting: ");
        for (T1Vector vector : vectors) {
            System.out.println(vector);
        }
    }

    static void task2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of domain names: ");
        int numDomains = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        T2Domain[] domains = new T2Domain[numDomains];

        for (int i = 0; i < numDomains; i++) {
            System.out.print("Enter domain name #" + (i + 1) + ": ");
            String name = scanner.nextLine();
            domains[i] = new T2Domain(name);
        }

        Arrays.sort(domains);

        System.out.println("Sorted reverse domain names:");

        for (T2Domain domain : domains) {
            System.out.println(domain.getReverseName());
        }
    }

    static void task3(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array elements: ");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        Integer[] array = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }

        System.out.println("Before sorting: " + Arrays.toString(array));

        T3StableSortWrapper.stableSort(array, Comparator.naturalOrder());

        System.out.println("After sorting: " + Arrays.toString(array));
    }
}