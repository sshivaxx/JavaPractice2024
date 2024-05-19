import ch.four.T1TwoThreeTree;
import ch.four.T2RedBlackTree;
import ch.four.T3TwoThreeST;
import ch.four.T4TwoThreeFourTree;

import java.security.SecureRandom;
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
        T1TwoThreeTree tree = new T1TwoThreeTree();
        SecureRandom rand = new SecureRandom();

        int N = 10;
        for (int i = 0; i < N; i++) {
            tree.insert(rand.nextInt(100));
        }

        System.out.println("Средняя длина пути: " + tree.averagePathLength());
        //В случае случайных вставок, дерево 2-3 будет близко к сбалансированному, и поэтому можно ожидать,
        //что средняя длина пути будет приблизительно  logb(N), где b — фактор ветвления
        //В контексте 2-3 дерева,b обычно будет между 2 и 3, так как каждый узел может иметь от 2 до 3 детей.
    }

    static void task2() {
        T2RedBlackTree tree = new T2RedBlackTree();
        SecureRandom rand = new SecureRandom();


        int N = 10;
        for (int i = 0; i < N; i++) {
            tree.insert(rand.nextInt(100));
        }

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);

        tree.printTree();

        if (tree.getRoot() != null) {
            System.out.println("Root key: " + tree.getRoot().getKeys());
            System.out.println("Root colour: " + tree.getRoot().getColor());
        }
    }

    static void task3() {
        T3TwoThreeST<Integer, String> tree = new T3TwoThreeST<>();

        tree.put(10, "Value 10");
        tree.put(20, "Value 20");
        tree.put(30, "Value 30");
        tree.put(40, "Value 40");
        tree.put(50, "Value 50");

        System.out.println("Get 30: " + tree.get(30));
        System.out.println("Get 40: " + tree.get(40));
        System.out.println("Get 10: " + tree.get(10));

        tree.delete(20);
        System.out.println("Get 20 after deletion: " + tree.get(20));

        tree.delete(30);
        System.out.println("Get 30 after deletion: " + tree.get(30));
    }

    static void task4() {
        T4TwoThreeFourTree<Integer> tree = new T4TwoThreeFourTree<>();

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(15);
        tree.insert(30);
        tree.insert(25);

        System.out.println("Search 10: " + tree.search(10)); // Should print 10
        System.out.println("Search 20: " + tree.search(20)); // Should print 20
        System.out.println("Search 25: " + tree.search(25)); // Should print 25
        System.out.println("Search 5: " + tree.search(5));   // Should print 5
        System.out.println("Search 7: " + tree.search(7));   // Should print null
    }
}