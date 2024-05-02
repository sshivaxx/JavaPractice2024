package ch.four;

import java.util.ArrayList;
import java.util.List;

public class T3TwoThreeST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private int count;
        private final Key[] keys;
        private final Value[] values;
        private final List<Node> children = new ArrayList<>();

        public Node(int count) {
            this.count = count;
            keys = (Key[]) new Comparable[3];
            values = (Value[]) new Object[3];
        }

        public boolean isLeaf() {
            return children.getFirst() == null;
        }
    }

    public void TwoThreeST() {
        root = null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null)
            return null;

        for (int i = 0; i < node.count; i++) {
            int cmp = key.compareTo(node.keys[i]);
            if (cmp == 0)
                return node.values[i];
            else if (cmp < 0)
                return get(node.children.get(i), key);
        }

        return get(node.children.get(node.count), key);
    }

    public void put(Key key, Value value) {
        if (root == null) {
            Node newNode = new Node(1);
            newNode.keys[0] = key;
            newNode.values[0] = value;
            root = newNode;
        } else {
            root = put(root, key, value);
        }
    }

    private Node put(Node node, Key key, Value value) {
        if (node.isLeaf()) {
            int i = node.count - 1;
            while (i >= 0 && key.compareTo(node.keys[i]) < 0) {
                node.keys[i + 1] = node.keys[i];
                node.values[i + 1] = node.values[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.values[i + 1] = value;
            node.count++;
        } else {
            int i = 0;
            while (i < node.count && key.compareTo(node.keys[i]) > 0) {
                i++;
            }
            Node newNode = put(node.children.get(i), key, value);
            if (newNode != node.children.get(i)) {
                int j = node.count - 1;
                while (j >= i) {
                    node.keys[j + 1] = node.keys[j];
                    node.children.set(j + 2, node.children.get(j + 1));
                    j--;
                }
                node.keys[i] = newNode.keys[0];
                node.children.set(i + 1, newNode);
                node.count++;
            }
        }

        if (node.count > 2) {
            return split(node);
        } else {
            return node;
        }
    }

    private Node split(Node node) {
        Node newNode = new Node(1);
        Node newChildNode = new Node(1);
        newNode.keys[0] = node.keys[1];
        newNode.values[0] = node.values[1];
        node.count = 1;
        newNode.children.set(0, node);
        newNode.children.set(1, newChildNode);
        return newNode;
    }

    public void delete(Key key) {
        if (root == null) {
            return;
        }

        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node.isLeaf()) {
            int i = 0;
            while (i < node.count && key.compareTo(node.keys[i]) > 0) {
                i++;
            }
            if (i < node.count && key.compareTo(node.keys[i]) == 0) {
                for (int j = i; j < node.count - 1; j++) {
                    node.keys[j] = node.keys[j + 1];
                    node.values[j] = node.values[j + 1];
                }
                node.count--;
            }
        } else {
            int i = 0;
            while (i < node.count && key.compareTo(node.keys[i]) > 0) {
                i++;
            }
            Node child = delete(node.children.get(i), key);
            if (child != node.children.get(i)) {
                int j = i;
                while (j < node.count - 1) {
                    node.keys[j] = node.keys[j + 1];
                    node.children.set(j + 1, node.children.get(j + 2));
                    j++;
                }
                node.count--;
            }
        }

        if (node.count == 0) {
            node = node.children.getFirst();
        }

        return node;
    }
}