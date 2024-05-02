import java.util.Scanner;

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
                task = 0;
            }
            System.out.println("Enter 0 to end or another symbol to continue");
            replay = scanner.nextInt();
        } while (replay != 0);
    }

    static void task1() {
        System.out.println("Look in the file with realization!!");
    }

    static void task2() {
        System.out.println("Look in the file with realization!!");
    }

    static void task3() {
        System.out.println("Look in the file with realization!!");
    }

    static void task4() {
        System.out.println("Look in the file with realization!!");
    }
}