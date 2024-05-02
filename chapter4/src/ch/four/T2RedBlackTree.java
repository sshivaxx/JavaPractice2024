package ch.four;

import java.util.Objects;

public class T2RedBlackTree {
    private NodeT2 root;

    public void RedBlackTree() {
        root = null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new NodeT2();
            root.getKeys().add(key);
            root.setColor(Color.BLACK);
        } else {
            NodeT2 newNode = insertRecursive(root, key);
            fixTree(newNode);
        }
    }

    private NodeT2 insertRecursive(NodeT2 node, int key) {
        if (node.getKeys().size() == 3) {  // 4-node
            if (key < node.getKeys().get(0)) {
                return insertRecursive(node.getChildren().getFirst(), key);
            } else if (key > node.getKeys().get(2)) {
                return insertRecursive(node.getChildren().get(3), key);
            } else {
                return insertRecursive(node.getChildren().get(1), key);
            }
        } else if (node.getKeys().size() == 2) {  // 3-node
            if (key < node.getKeys().getFirst()) {
                return insertRecursive(node.getChildren().getFirst(), key);
            } else {
                return insertRecursive(node.getChildren().get(1), key);
            }
        } else {  // 2-node or leaf node
            node.getKeys().add(key);
            node.getKeys().sort(null);
            return node;
        }
    }

    private void fixTree(NodeT2 node) {
        if (node == root) {
            node.setColor(Color.BLACK);
        } else {
            NodeT2 parent = getParent(node);
            assert parent != null;
            if (parent.getColor() == Color.BLACK) {
                // No violation, tree is still valid
                return;
            }

            NodeT2 grandparent = getParent(parent);
            NodeT2 uncle = getUncle(node);

            if (uncle != null && uncle.getColor() == Color.RED) {
                // Case 1: Uncle is red
                parent.setColor(Color.BLACK);
                uncle.setColor(Color.BLACK);
                assert grandparent != null;
                grandparent.setColor(Color.RED);
                fixTree(grandparent);
            } else {
                // Case 2: Uncle is black or missing
                if (node == parent.getChildren().get(0) && parent ==
                        Objects.requireNonNull(grandparent).getChildren().getFirst()) {
                    // Left-Left case
                    rotateRight(grandparent);
                    parent.setColor(Color.BLACK);
                    grandparent.setColor(Color.RED);
                } else if (node == parent.getChildren().get(1) && parent ==
                        Objects.requireNonNull(grandparent).getChildren().getFirst()) {
                    // Left-Right case
                    rotateLeft(parent);
                    fixTree(parent);
                } else if (node == parent.getChildren().get(1) && parent ==
                        Objects.requireNonNull(grandparent).getChildren().get(1)) {
                    // Right-Right case
                    rotateLeft(grandparent);
                    parent.setColor(Color.BLACK);
                    grandparent.setColor(Color.RED);
                } else {
                    if (node == parent.getChildren().getFirst()) {
                        assert grandparent != null;
                        if (parent == grandparent.getChildren().get(1)) {
                            // Right-Left case
                            rotateRight(parent);
                            fixTree(parent);
                        }
                    }
                }
            }
        }
    }

    private NodeT2 getParent(NodeT2 node) {
        // Returns the parent of the given node
        for (NodeT2 child : root.getChildren()) {
            if (child.getChildren().contains(node)) {
                return child;
            }
        }
        return null;
    }

    private NodeT2 getUncle(NodeT2 node) {
        // Returns the uncle of the given node
        NodeT2 parent = getParent(node);
        NodeT2 grandparent = getParent(parent);
        if (grandparent == null) {
            return null;
        }
        if (parent == grandparent.getChildren().get(0)) {
            return grandparent.getChildren().get(1);
        } else {
            return grandparent.getChildren().getFirst();
        }
    }

    private void rotateLeft(NodeT2 node) {
        // Performs a left rotation around the given node
        NodeT2 parent = getParent(node);
        NodeT2 grandparent = getParent(parent);
        assert grandparent != null;
        if (parent == grandparent.getChildren().getFirst()) {
            grandparent.getChildren().set(0, node);
        } else {
            grandparent.getChildren().set(1, node);
        }
        assert parent != null;
        parent.getChildren().set(1, node.getChildren().getFirst());
        node.getChildren().set(0, parent);
    }

    private void rotateRight(NodeT2 node) {
        // Performs a right rotation around the given node
        NodeT2 parent = getParent(node);
        NodeT2 grandparent = getParent(parent);
        assert parent != null;
        parent.getChildren().set(0, node.getChildren().get(1));
        node.getChildren().set(1, parent);
        assert grandparent != null;
        if (parent == grandparent.getChildren().getFirst()) {
            grandparent.getChildren().set(0, node);
        } else {
            grandparent.getChildren().set(1, node);
        }
    }
}
