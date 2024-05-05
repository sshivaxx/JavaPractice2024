package ch.six;
import java.util.Arrays;
//5.1.17
public class T4InPlaceRadixSort {
    public static void inPlaceRadixSort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    public static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Подсчитываем количество встречающихся цифр
        for (int j : array) {
            count[(j / exp) % 10]++;
        }

        // Преобразуем count[i] так, чтобы оно содержало фактическую позицию
        // данной цифры в выходном массиве
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Строим выходной массив
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Копируем отсортированный массив в исходный
        System.arraycopy(output, 0, array, 0, n);
    }
}

