import java.util.NoSuchElementException;

public class task4DoubleStack<T> {
    private Deque<T> deque;

    public task4DoubleStack() {
        deque = new Deque<>();
    }

    public void pushFirst(T item) {
        deque.addFirst(item);
    }

    public void pushLast(T item) {
        deque.addLast(item);
    }

    public T popFirst() {
        if (deque.isEmpty()) {
            throw new NoSuchElementException("Stack 1 is empty");
        }
        return deque.removeFirst();
    }

    public T popLast() {
        if (deque.isEmpty()) {
            throw new NoSuchElementException("Stack 2 is empty");
        }
        return deque.removeLast();
    }
}