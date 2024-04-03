public class Main {
    public static void main(String[] args) {
        LinkedStackQueue<Integer> stackQueue = new LinkedStackQueue<>();

        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);

        System.out.println(stackQueue.pop());

        stackQueue.append(4);
        stackQueue.append(5);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.peek());
        System.out.println(stackQueue.isEmpty());
    }
}