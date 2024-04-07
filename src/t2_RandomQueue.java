import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomQueue<T> {
    private List<T> queue;
    private Random random;

    public RandomQueue() {
        queue = new ArrayList<>();
        random = new Random();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int randomIndex = random.nextInt(queue.size());
        return queue.remove(randomIndex);
    }

    public T sample() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int randomIndex = random.nextInt(queue.size());
        return queue.get(randomIndex);
    }
}