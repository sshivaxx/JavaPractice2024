package ch.three;

public class T2Bst {
    private Node root;
    private Node lastAccessedNode;

    public void put(int key) {
        root = put(root, key);
    }

    private Node put(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = put(node.left, key);
        } else if (key > node.key) {
            node.right = put(node.right, key);
        } else {
            node.key = key;
        }

        return node;
    }

    public int get(int key) {
        if (lastAccessedNode != null && lastAccessedNode.key == key) {
            return lastAccessedNode.key;
        }

        Node node = get(root, key);
        lastAccessedNode = node;

        return (node != null) ? node.key : -1;
    }

    private Node get(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }
}
