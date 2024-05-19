package ch.four;

import java.util.ArrayList;
import java.util.List;

public class T3TwoThreeST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private int count;
        private final Key[] keys;
        private final Value[] values;
        private final List<Node> children;

        @SuppressWarnings("unchecked")
        public Node(int count) {
            this.count = count;
            keys = (Key[]) new Comparable[3];
            values = (Value[]) new Object[3];
            children = new ArrayList<>(4);
            for (int i = 0; i < 4; i++) {
                children.add(null);
            }
        }

        public boolean isLeaf() {
            return children.get(0) == null;
        }
    }

    public T3TwoThreeST() {
        root = null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int i = 0;
        while (i < node.count && key.compareTo(node.keys[i]) > 0) {
            i++;
        }

        if (i < node.count && key.compareTo(node.keys[i]) == 0) {
            return node.values[i];
        } else if (node.isLeaf()) {
            return null;
        } else {
            return get(node.children.get(i), key);
        }
    }

    public void put(Key key, Value value) {
        if (root == null) {
            Node newNode = new Node(1);
            newNode.keys[0] = key;
            newNode.values[0] = value;
            root = newNode;
        } else {
            Node newNode = put(root, key, value);
            if (newNode != null) {
                Node newRoot = new Node(1);
                newRoot.keys[0] = newNode.keys[0];
                newRoot.values[0] = newNode.values[0];
                newRoot.children.set(0, root);
                newRoot.children.set(1, newNode.children.get(1));
                root = newRoot;
            }
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
            if (newNode != null) {
                for (int j = node.count; j > i; j--) {
                    node.keys[j] = node.keys[j - 1];
                    node.values[j] = node.values[j - 1];
                    node.children.set(j + 1, node.children.get(j));
                }
                node.keys[i] = newNode.keys[0];
                node.values[i] = newNode.values[0];
                node.children.set(i + 1, newNode.children.get(1));
                node.count++;
            }
        }

        if (node.count > 2) {
            return split(node);
        } else {
            return null;
        }
    }

    private Node split(Node node) {
        Node newNode = new Node(1);
        Node newChildNode = new Node(1);
        newNode.keys[0] = node.keys[1];
        newNode.values[0] = node.values[1];
        newNode.children.set(0, node);
        newNode.children.set(1, newChildNode);
        newChildNode.keys[0] = node.keys[2];
        newChildNode.values[0] = node.values[2];
        newChildNode.children.set(0, node.children.get(2));
        newChildNode.children.set(1, node.children.get(3));
        node.count = 1;
        node.keys[1] = null;
        node.values[1] = null;
        node.keys[2] = null;
        node.values[2] = null;
        node.children.set(2, null);
        node.children.set(3, null);
        return newNode;
    }

    public void delete(Key key) {
        if (root == null) {
            return;
        }

        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }

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
            node.children.set(i, delete(node.children.get(i), key));
        }

        if (node.count == 0) {
            node = node.children.get(0);
        }

        return node;
    }
}