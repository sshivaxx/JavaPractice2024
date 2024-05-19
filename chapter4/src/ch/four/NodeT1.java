package ch.four;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeT1 {
    private final List<Integer> keys;
    private final List<NodeT1> children;

    public NodeT1() {
        keys = new ArrayList<>();
        children = new ArrayList<>(Collections.nCopies(3, null)); // Инициализируем список детей с тремя пустыми элементами
    }

    public List<Integer> getKeys() {
        return keys;
    }

    public List<NodeT1> getChildren() {
        return children;
    }
}

