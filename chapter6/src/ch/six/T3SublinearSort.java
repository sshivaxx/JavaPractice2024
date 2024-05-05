package ch.six;
import java.util.Arrays;
import java.util.stream.IntStream;
//5.1.15
public class T3SublinearSort {
    public static void sublinearSort(int[] array) {
        int n = array.length;

        int[] aux = new int[n];
        int[] count = new int[65537]; // 2^16 + 1
        int[] prefixSum = new int[65537]; // 2^16 + 1

        for (int d = 0; d < 16; d += 8) {
            Arrays.fill(count, 0);

            for (int j : array) {
                int bucket = (j >> d) & 0xFF;
                count[bucket + 1]++;
            }

            IntStream.range(0, 65536).forEach(i -> prefixSum[i + 1] = prefixSum[i] + count[i]);

            for (int j : array) {
                int bucket = (j >> d) & 0xFF;
                aux[prefixSum[bucket]++] = j;
            }

            System.arraycopy(aux, 0, array, 0, n);
        }


        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
