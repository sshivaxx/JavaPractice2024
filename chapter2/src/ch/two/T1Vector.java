package ch.two;
import java.util.Arrays;
//2.5.21
public class T1Vector implements Comparable<T1Vector> {
    private final int[] components;

    public T1Vector(int... components) {
        this.components = components;
    }

    @Override
    public int compareTo(T1Vector other) {
        for (int i = 0; i < components.length; i++) {
            if (components[i] < other.components[i]) {
                return -1;
            } else if (components[i] > other.components[i]) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(components);
    }
}
