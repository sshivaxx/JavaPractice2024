import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.io.File;
import ch.two.t1Vector;
import ch.two.t2Domain;
import ch.two.t3StableSortWrapper;

public class Main {
    public static void main(String[] args) {
        int task, replay = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number of task(from 1 to 4): ");
            task = scanner.nextInt();
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

    static void task1(){
        t1Vector[] vectors = {
                new t1Vector(3, 1, 4, 2),
                new t1Vector(2, 4, 1, 3),
                new t1Vector(2, 2, 3, 1),
                new t1Vector(1, 2, 3, 4)
        };
        System.out.println("Before sorting: ");
        for (t1Vector vector : vectors) {
            System.out.println(vector);
        }
        Arrays.sort(vectors);
        System.out.println("After sorting: ");
        for (t1Vector vector : vectors) {
            System.out.println(vector);
        }
    }

    static void task2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of domain names: ");
        int numDomains = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        t2Domain[] domains = new t2Domain[numDomains];

        for (int i = 0; i < numDomains; i++) {
            System.out.print("Enter domain name #" + (i + 1) + ": ");
            String name = scanner.nextLine();
            domains[i] = new t2Domain(name);
        }

        Arrays.sort(domains);

        System.out.println("Sorted reverse domain names:");

        for (t2Domain domain : domains) {
            System.out.println(domain.getReverseName());
        }
    }

    static void task3(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элементы массива через пробел: ");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        Integer[] array = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }

        System.out.println("Before sorting: " + Arrays.toString(array));

        t3StableSortWrapper.stableSort(array, Comparator.naturalOrder());

        System.out.println("After sorting: " + Arrays.toString(array));
    }

    static void task4(){
        //2.5.28
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scan.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directoryPath);
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Unable to read files from directory: " + directoryPath);
            return;
        }

        Arrays.sort(files);

        System.out.println("Files in directory " + directoryPath + ", sorted alphabetically:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}