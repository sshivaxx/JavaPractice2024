package ch.five;

import java.util.LinkedList;

//3.4.36
public class T4SeparateChainingHashTable {
    private final LinkedList<Integer>[] table;

    public T4SeparateChainingHashTable(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(int key) {
        int index = key % table.length;
        table[index].add(key);
    }

    public int getMinListLength() {
        int min = Integer.MAX_VALUE;
        for (LinkedList<Integer> list : table) {
            if (list.size() < min) {
                min = list.size();
            }
        }
        return min;
    }

    public int getMaxListLength() {
        int max = 0;
        for (LinkedList<Integer> list : table) {
            if (list.size() > max) {
                max = list.size();
            }
        }
        return max;
    }
}