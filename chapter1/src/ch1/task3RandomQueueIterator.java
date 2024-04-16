package ch1;

import java.util.Iterator;

public class task3RandomQueueIterator<T> implements Iterator<T> {
    private final task2RandomQueue<T> queue;

    public task3RandomQueueIterator(task2RandomQueue<T> queue) {
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