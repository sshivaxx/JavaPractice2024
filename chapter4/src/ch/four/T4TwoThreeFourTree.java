package ch.four;

import java.util.ArrayList;
import java.util.List;

public class T4TwoThreeFourTree<T extends Comparable<T>> {
    private Node root;

    private class Node {
        private final List<T> keys;
        private final List<Node> children;

        public Node() {
            keys = new ArrayList<>();
            children = new ArrayList<>();
        }
    }

    public void TwoThreeFourTree() {
        root = null;
    }

    public T search(T key) {
        return searchRecursive(root, key);
    }

    private T searchRecursive(Node node, T key) {
        if (node == null) {
            return null;
        }

        int index = findIndex(node.keys, key);

        if (index < node.keys.size() && node.keys.get(index).equals(key)) {
            return node.keys.get(index);
        } else if (node.children.isEmpty()) {
            return null;
        } else {
            return searchRecursive(node.children.get(index), key);
        }
    }

    public void insert(T key) {
        if (root == null) {
            root = new Node();
            root.keys.add(key);
        } else {
            insertRecursive(root, key);
        }
    }

    private void insertRecursive(Node node, T key) {
        if (node.children.isEmpty()) {
            insertKey(node, key);
        } else {
            int index = findIndex(node.keys, key);

            if (index < node.keys.size() && node.keys.get(index).equals(key)) {
                // Duplicate keys are not allowed
                return;
            }

            Node child = node.children.get(index);
            if (child.keys.size() == 3) { // Split child node if it is full
                splitChild(node, index);
                if (key.compareTo(node.keys.get(index)) > 0) {
                    index++;
                }
                child = node.children.get(index);
            }
            insertRecursive(child, key);
        }
    }

    private void insertKey(Node node, T key) {
        int index = findIndex(node.keys, key);
        node.keys.add(index, key);
    }

    private void splitChild(Node parentNode, int childIndex) {
        Node childNode = parentNode.children.get(childIndex);
        Node newNode = new Node();

        newNode.keys.add(childNode.keys.remove(2));
        newNode.keys.add(childNode.keys.remove(1));

        if (!childNode.children.isEmpty()) {
            newNode.children.add(childNode.children.remove(2));
            newNode.children.add(childNode.children.remove(1));
        }

        parentNode.keys.add(childIndex, childNode.keys.remove(0));
        parentNode.children.add(childIndex + 1, newNode);
    }

    private int findIndex(List<T> keys, T key) {
        int index = 0;
        while (index < keys.size() && key.compareTo(keys.get(index)) > 0) {
            index++;
        }
        return index;
    }
}