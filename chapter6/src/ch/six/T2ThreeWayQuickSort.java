package ch.six;
import java.util.Arrays;
//5.1.14
public class T2ThreeWayQuickSort {
    public static void quickSortArrays(int[][] arrays, int low, int high) {
        if (low < high) {
            int[] pivot = arrays[low];
            int lt = low;
            int gt = high;
            int i = low + 1;
            while (i <= gt) {
                int cmp = compare(arrays[i], pivot);
                if (cmp < 0) {
                    swap(arrays, lt++, i++);
                } else if (cmp > 0) {
                    swap(arrays, i, gt--);
                } else {
                    i++;
                }
            }
            quickSortArrays(arrays, low, lt - 1);
            quickSortArrays(arrays, gt + 1, high);
        }
    }

    public static int compare(int[] a, int[] b) {
        int minLength = Math.min(a.length, b.length);
        for (int i = 0; i < minLength; i++) {
            if (a[i] != b[i]) {
                return a[i] - b[i];
            }
        }
        return a.length - b.length;
    }

    public static void swap(int[][] arrays, int i, int j) {
        int[] temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void printArrays(int[][] arrays) {
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }
}
