import java.util.Iterator;

public class t3_RandomQueueIterator<T> implements Iterator<T> {
    private final t2_RandomQueue<T> queue;

    public t3_RandomQueueIterator(t2_RandomQueue<T> queue) {
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