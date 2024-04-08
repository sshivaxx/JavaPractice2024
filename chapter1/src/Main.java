public class Main {
    public static void main(String[] args) {
        //solved task 1
        t1_LinkedStackQueue<Integer> stackQueue = new t1_LinkedStackQueue<>();

        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);

        System.out.println("Task 1:");
        System.out.println(stackQueue.pop());

        stackQueue.append(4);
        stackQueue.append(5);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.peek());
        System.out.println(stackQueue.isEmpty());
        //solved task 2
        t2_RandomQueue<String> queue = new t2_RandomQueue<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("Task 2:");
        System.out.println("Queue size: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("Dequeued item: " + queue.dequeue());
        }
        //solved task3
        t2_RandomQueue<Integer> randomQueue = new t2_RandomQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);

        System.out.println("Task 3:");
        t3_RandomQueueIterator<Integer> iterator = new t3_RandomQueueIterator<>(randomQueue);
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            System.out.println(item);
        }

        //solved task4
        t4_DoubleStack<Integer> doubleStack = new t4_DoubleStack<>();

        doubleStack.push1(1);
        doubleStack.push1(2);
        doubleStack.push1(3);

        doubleStack.push2(4);
        doubleStack.push2(5);
        doubleStack.push2(6);

        System.out.println("Task 4:");
        System.out.println(doubleStack.pop1());
        System.out.println(doubleStack.pop1());
        System.out.println(doubleStack.pop1());


        System.out.println(doubleStack.pop2());
        System.out.println(doubleStack.pop2());
        System.out.println(doubleStack.pop2());
    }
}