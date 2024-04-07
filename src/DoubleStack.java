import java.util.NoSuchElementException;

public class DoubleStack<T> {
    private Deque<T> deque;

    public DoubleStack() {
        deque = new Deque<>();
    }

    public void push1(T item) {
        deque.addFirst(item);
    }

    public void push2(T item) {
        deque.addLast(item);
    }

    public T pop1() {
        if (deque.isEmpty()) {
            throw new NoSuchElementException("Stack 1 is empty");
        }
        return deque.removeFirst();
    }

    public T pop2() {
        if (deque.isEmpty()) {
            throw new NoSuchElementException("Stack 2 is empty");
        }
        return deque.removeLast();
    }
}