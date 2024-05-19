import ch.seven.T1TrieST;
import ch.seven.T1Tst;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static ch.seven.T4SubstringMatcher.insertWord;
import static ch.seven.T4SubstringMatcher.search;

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
        System.out.println("For TrieST: ");
        T1TrieST trie = new T1TrieST();
        trie.insert("hello");
        trie.insert("helium");

        System.out.println(trie.search("hello")); // true
        System.out.println(trie.search("helium")); // true

        trie.compress(); // Compress the trie

        System.out.println(trie.search("hello")); // true
        System.out.println(trie.search("helium")); // true

        System.out.println("For TST");
        T1Tst<Integer> tst = new T1Tst<>();
        tst.put("apple", 1);
        tst.put("app", 2);
        tst.put("apricot", 3);

        System.out.println(tst.get("apple"));   // 1
        System.out.println(tst.get("app"));     // 2
        System.out.println(tst.get("apricot")); // 3

        tst.compress(); // Compress the TST

        System.out.println(tst.get("apple"));   // 1
        System.out.println(tst.get("app"));     // 2
        System.out.println(tst.get("apricot")); // 3
    }

    static void task2() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int L = scanner.nextInt();

        T1Tst<Boolean> tst = new T1Tst<>();
        int uniqueCount = 0;

        for (int i = 0; i <= text.length() - L; i++) {
            String substring = text.substring(i, i + L);
            if (tst.contains(substring)) {
                tst.put(substring, true);
                uniqueCount++;
            }
        }

        System.out.println("Number of unique substrings of length " + L + ": " + uniqueCount);
    }

    static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        T1Tst<Boolean> tst = new T1Tst<>();
        Set<String> uniqueSubstrings = new HashSet<>();

        // Вставка всех подстрок в TST
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String substring = text.substring(i, j);
                if (tst.contains(substring)) {
                    tst.put(substring, true);
                    uniqueSubstrings.add(substring);
                }
            }
        }

        System.out.println("Number of unique substrings: " + uniqueSubstrings.size());
    }

    static void task4() {
        Scanner scanner = new Scanner(System.in);
        T1Tst<List<String>> tst = new T1Tst<>();

        System.out.println("Enter the number of words:");
        int wordCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < wordCount; i++) {
            System.out.println("Enter word " + (i + 1) + ":");
            String word = scanner.nextLine();
            insertWord(tst, word);
        }

        System.out.println("Enter the number of queries:");
        int queryCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < queryCount; i++) {
            System.out.println("Enter query " + (i + 1) + ":");
            String query = scanner.nextLine();
            List<String> result = search(tst, query);
            System.out.println("Words containing '" + query + "': " + result);
        }
    }
}