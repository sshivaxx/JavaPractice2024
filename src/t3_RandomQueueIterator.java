import java.util.Iterator;

public class RandomQueueIterator<T> implements Iterator<T> {
    private final RandomQueue<T> queue;

    public RandomQueueIterator(RandomQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        return queue.dequeue();
    }
}