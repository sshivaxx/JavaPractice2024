import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int task;
        do {
            Scanner scanner  = new Scanner(System.in);
            System.out.println("Enter the number of task(from 1 to 4): ");
            task = scanner.nextInt();
            if (task == 1) {
                task1();
                task = againOrExit();
            }else if (task == 2) {
                task2();
                task = againOrExit();
            }else if (task == 3) {
                task3();
                task = againOrExit();
            }else if (task == 4) {
                task4();
                task = againOrExit();
            }else {
                System.out.println("Invalid input");
                task = 0;
            }
        } while(task == 0);
    }

    static int againOrExit(){
        int again = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to continue (Y/N): ");
        String input = scan.nextLine();
        if(input.equalsIgnoreCase("Y")){
            again = 0;
        } else if(input.equalsIgnoreCase("N")){
            System.exit(0);
        }
        return again;
    }

    static void task1(){
        task1LinkedStackQueue<Integer> stackQueue = new task1LinkedStackQueue<>();

        stackQueue.pushInBegin(1);
        stackQueue.pushInBegin(2);
        stackQueue.pushInBegin(3);

        System.out.println("Task 1:");
        System.out.println(stackQueue.pop());

        stackQueue.appendInEnd(4);
        stackQueue.appendInEnd(5);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.peek());
        System.out.println(stackQueue.isEmpty());
    }
    static void task2(){
        //solved task 2
        task2RandomQueue<String> queue = new task2RandomQueue<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("Task 2:");
        System.out.println("Queue size: " + queue.getQueueSize());

        while (!queue.isEmpty()) {
            System.out.println("Dequeued item: " + queue.dequeue());
        }
    }

    static void task3(){
        //solved task3
        task2RandomQueue<Integer> randomQueue = new task2RandomQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);

        System.out.println("Task 3:");
        task3RandomQueueIterator<Integer> iterator = new task3RandomQueueIterator<>(randomQueue);
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            System.out.println(item);
        }
    }

    static void task4(){
        task4DoubleStack<Integer> doubleStack = new task4DoubleStack<>();

        doubleStack.pushFirst(1);
        doubleStack.pushFirst(2);
        doubleStack.pushFirst(3);

        doubleStack.pushLast(4);
        doubleStack.pushLast(5);
        doubleStack.pushLast(6);

        System.out.println("Task 4:");
        System.out.println(doubleStack.popFirst());
        System.out.println(doubleStack.popFirst());
        System.out.println(doubleStack.popFirst());


        System.out.println(doubleStack.popLast());
        System.out.println(doubleStack.popLast());
        System.out.println(doubleStack.popLast());
    }
}