import java.util.Scanner;
import ch.three.Node;
import ch.three.T1PerfectlyBalancedTree;
import ch.three.T2Bst;
import ch.three.T3BinaryTreeChecker;
import ch.three.T4SelectRankChecker;

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
        System.out.print("Enter amount of keys: ");
        int count = scanner.nextInt();

        int[] keys = new int[count];
        System.out.println("Enter keys:");
        for (int j = 0; j < count; j++) {
            keys[j] = scanner.nextInt();
        }

        Node root = T1PerfectlyBalancedTree.balanceKeys(keys);

        System.out.println("Perfectly balanced tree:");
        T1PerfectlyBalancedTree.inOrderTraversal(root);
    }

    static void task2(){
        T2Bst bst = new T2Bst();

        bst.put(5);
        bst.put(2);
        bst.put(7);

        int value1 = bst.get(2);
        System.out.println("Value of key 2: " + value1);

        int value2 = bst.get(5);
        System.out.println("Value of key 5: " + value2);

        int value3 = bst.get(7);
        System.out.println("Value of key 7: " + value3);

        int value4 = bst.get(10);
        System.out.println("Value of key 10: " + value4);
    }

    static void task3(){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        boolean isBST = T3BinaryTreeChecker.isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("The tree is binary: " + isBST);
    }

    static void task4(){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        boolean isValid = T4SelectRankChecker.checkSelectRank(root);
        System.out.println("The selection and rank properties are satisfied: " + isValid);
    }
}