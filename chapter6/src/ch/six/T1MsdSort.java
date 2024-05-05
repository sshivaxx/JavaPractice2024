package ch.six;
import java.util.LinkedList;
import java.util.Queue;
//5.1.11
public class T1MsdSort {
    private static final int R = 256;

    public static void sort(String[] arr) {
        Queue<String>[] buckets = new Queue[R + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (String str : arr) {
            int index = str.isEmpty() ? 0 : str.charAt(0) + 1;
            buckets[index].add(str);
        }

        for (int i = 0; i < buckets.length; i++) {
            if (!buckets[i].isEmpty()) {
                String[] subArray = new String[buckets[i].size()];
                int j = 0;
                for (String str : buckets[i]) {
                    subArray[j++] = str.substring(1);
                }
                sort(subArray);

                j = 0;
                for (String str : subArray) {
                    buckets[i].remove();
                    buckets[i].add((char) (i - 1) + str);
                    arr[j++] = buckets[i].remove();
                }
            }
        }
    }
}
