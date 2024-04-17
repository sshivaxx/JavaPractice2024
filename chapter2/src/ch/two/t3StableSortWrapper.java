package ch.two;
import java.util.Arrays;
import java.util.Comparator;
//2.5.18
public class t3StableSortWrapper {
    public static <T> void stableSort(T[] array, Comparator<? super T> comparator) {
        IndexedItem<T>[] indexedArray = new IndexedItem[array.length];
        for (int i = 0; i < array.length; i++) {
            indexedArray[i] = new IndexedItem<>(array[i], i);
        }
        Arrays.sort(indexedArray, Comparator.comparing(IndexedItem::item, comparator));
        for (int i = 0; i < array.length; i++) {
            array[i] = indexedArray[i].item();
        }
    }

    private record IndexedItem<T>(T item, int index) {
    }
}
