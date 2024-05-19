package ch.seven;

public class T1Tst<Value> {
    private Node root;

    private class Node {
        private char c;
        private Node left, mid, right;
        private Value val;
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) x.left = put(x.left, key, val, d);
        else if (c > x.c) x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d + 1);
        else x.val = val;
        return x;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid, key, d + 1);
        else return x;
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    public boolean contains(String key) {
        return get(key) == null;
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c < x.c) x.left = delete(x.left, key, d);
        else if (c > x.c) x.right = delete(x.right, key, d);
        else if (d < key.length() - 1) x.mid = delete(x.mid, key, d + 1);
        else x.val = null;

        if (x.val != null) return x;
        if (x.left != null || x.mid != null || x.right != null) return x;
        return null;
    }

    private Node compress(Node x) {
        if (x == null) return null;
        x.left = compress(x.left);
        x.mid = compress(x.mid);
        x.right = compress(x.right);

        if (x.val == null && x.mid != null) {
            Node child = x.mid;
            x.c = child.c;
            x.left = child.left;
            x.mid = child.mid;
            x.right = child.right;
            x.val = child.val;
        }
        return x;
    }

    public void compress() {
        root = compress(root);
    }
}

