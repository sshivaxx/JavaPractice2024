package ch.seven;
import java.util.HashMap;

public class T1TrieST {
    private Node root = new Node();

    private static class Node {
        private final HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord = false;
    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node node, String word, int d) {
        if (node == null) node = new Node();
        if (d == word.length()) {
            node.isEndOfWord = true;
            return node;
        }
        char c = word.charAt(d);
        node.children.put(c, insert(node.children.get(c), word, d + 1));
        return node;
    }

    public boolean search(String word) {
        Node node = search(root, word, 0);
        return node != null && node.isEndOfWord;
    }

    private Node search(Node node, String word, int d) {
        if (node == null) return null;
        if (d == word.length()) return node;
        char c = word.charAt(d);
        return search(node.children.get(c), word, d + 1);
    }

    public void delete(String word) {
        root = delete(root, word, 0);
    }

    private Node delete(Node node, String word, int d) {
        if (node == null) return null;
        if (d == word.length()) {
            node.isEndOfWord = false;
        } else {
            char c = word.charAt(d);
            node.children.put(c, delete(node.children.get(c), word, d + 1));
        }
        if (node.isEndOfWord) return node;
        if (!node.children.isEmpty()) return node;
        return null;
    }

    private Node compress(Node node) {
        if (node == null) return null;
        for (char c : node.children.keySet()) {
            node.children.put(c, compress(node.children.get(c)));
        }
        if (node.children.size() == 1 && !node.isEndOfWord) {
            char onlyKey = node.children.keySet().iterator().next();
            Node onlyChild = node.children.get(onlyKey);
            node = new Node();
            node.children.put(onlyKey, onlyChild);
        }
        return node;
    }

    public void compress() {
        root = compress(root);
    }
}
