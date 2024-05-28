import chnine.Nfa;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        String regex = "^(0[01]*1)*0*$";
        System.out.println(Pattern.matches(regex, "10101")); // true
        System.out.println(Pattern.matches(regex, "100101")); // true
        System.out.println(Pattern.matches(regex, "1001")); // false (менее 2 нулей)
        System.out.println(Pattern.matches(regex, "10001")); // false (содержит последовательность нулей)
    }


    static void task2() {
        String regex = "^(0|1)*$";

        System.out.println(Pattern.matches(regex, "0"));      // true
        System.out.println(Pattern.matches(regex, "1"));      // true
        System.out.println(Pattern.matches(regex, "0101"));   // true
        System.out.println(Pattern.matches(regex, "11001"));  // true

        System.out.println(Pattern.matches(regex, "(0)")); // false (содержит скобки)
        System.out.println(Pattern.matches(regex, "(1.*0)")); // false (содержит скобки)
        System.out.println(Pattern.matches(regex, "(1(0 и 1)1)")); // false (содержит вложенные скобки)
    }

    static void task3() {
        Nfa nfa = new Nfa();
        nfa.addState(0);
        nfa.addState(1);
        nfa.addState(2);
        nfa.setInitialState(0);
        nfa.addFinalState(2);

        nfa.addTransition(0, '0', 1);
        nfa.addTransition(1, '1', 2);
        nfa.addTransition(0, '.', 2);

        System.out.println(nfa.accepts("01")); // true
        System.out.println(nfa.accepts("0")); // true
        System.out.println(nfa.accepts("1")); // false
    }

    static void task4() {
        Nfa nfa = new Nfa();

        nfa.addState(0);
        nfa.addState(1);
        nfa.addState(2);
        nfa.addState(3);

        nfa.setInitialState(0);
        nfa.addFinalState(3);

        nfa.addTransition(0, 'a', 1);
        nfa.addTransition(1, 'b', 2);
        nfa.addTransition(2, '+', 3);

        // Проверяем, принимает ли NFA строку "abb"
        System.out.println(nfa.accepts("abb")); // true

        // Проверяем, принимает ли NFA строку "ab"
        System.out.println(nfa.accepts("ab")); // false
    }

}