package ch.four;

import java.util.List;

public class T2RedBlackTree {
    private NodeT2 root;

    public T2RedBlackTree() {
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
        if (node.getChildren().isEmpty()) {  // Leaf node
            node.getKeys().add(key);
            node.getKeys().sort(null);
            return node;
        } else if (node.getKeys().size() == 2) {  // 3-node
            if (key < node.getKeys().get(0)) {
                if (node.getChildren().isEmpty()) {
                    node.getChildren().add(new NodeT2());
                }
                return insertRecursive(node.getChildren().getFirst(), key);
            } else if (key > node.getKeys().get(1)) {
                if (node.getChildren().size() < 2) {
                    node.getChildren().add(new NodeT2());
                }
                return insertRecursive(node.getChildren().get(1), key);
            } else {
                if (node.getChildren().size() < 3) {
                    node.getChildren().add(new NodeT2());
                }
                return insertRecursive(node.getChildren().get(1), key);
            }
        } else {  // 2-node
            if (key < node.getKeys().getFirst()) {
                if (node.getChildren().isEmpty()) {
                    node.getChildren().add(new NodeT2());
                }
                return insertRecursive(node.getChildren().getFirst(), key);
            } else {
                if (node.getChildren().size() < 2) {
                    node.getChildren().add(new NodeT2());
                }
                return insertRecursive(node.getChildren().get(1), key);
            }
        }
    }

    private void fixTree(NodeT2 node) {
        if (node == root) {
            node.setColor(Color.BLACK);
        } else {
            NodeT2 parent = getParent(node);
            if (parent != null && parent.getColor() == Color.RED) {
                NodeT2 grandparent = getParent(parent);
                NodeT2 uncle = getUncle(node);

                if (uncle != null && uncle.getColor() == Color.RED) {
                    parent.setColor(Color.BLACK);
                    uncle.setColor(Color.BLACK);
                    if (grandparent != null) {
                        grandparent.setColor(Color.RED);
                        fixTree(grandparent);
                    }
                } else {
                    if (parent.getChildren().get(0) == node) {
                        if (grandparent != null && grandparent.getChildren().getFirst() == parent) {
                            rotateRight(grandparent);
                        } else if (grandparent != null) {
                            rotateRight(parent);
                            rotateLeft(grandparent);
                        }
                    } else if (parent.getChildren().get(1) == node) {
                        if (grandparent != null && grandparent.getChildren().get(1) == parent) {
                            rotateLeft(grandparent);
                        } else if (grandparent != null) {
                            rotateLeft(parent);
                            rotateRight(grandparent);
                        }
                    }
                    if (parent != null) parent.setColor(Color.BLACK);
                    if (grandparent != null) grandparent.setColor(Color.RED);
                }
            }
        }
    }

    private NodeT2 getParent(NodeT2 node) {
        return findParent(root, node);
    }

    private NodeT2 findParent(NodeT2 current, NodeT2 node) {
        if (current == null || current.getChildren().isEmpty()) return null;
        for (NodeT2 child : current.getChildren()) {
            if (child == node) return current;
            NodeT2 parent = findParent(child, node);
            if (parent != null) return parent;
        }
        return null;
    }

    private NodeT2 getUncle(NodeT2 node) {
        NodeT2 parent = getParent(node);
        NodeT2 grandparent = getParent(parent);
        if (grandparent == null) return null;
        if (grandparent.getChildren().get(0) == parent) {
            return grandparent.getChildren().size() > 1 ? grandparent.getChildren().get(1) : null;
        } else {
            return grandparent.getChildren().getFirst();
        }
    }

    private void rotateLeft(NodeT2 node) {
        NodeT2 parent = getParent(node);
        NodeT2 grandparent = getParent(parent);
        if (parent != null) {
            NodeT2 newParent = node.getChildren().isEmpty() ? null : node.getChildren().getFirst();
            if (parent.getChildren().size() > 1) {
                parent.getChildren().set(1, newParent);
            } else {
                parent.getChildren().add(newParent);
            }
            if (newParent != null) node.getChildren().set(0, parent);
            if (grandparent != null) {
                if (grandparent.getChildren().getFirst() == parent) {
                    grandparent.getChildren().set(0, node);
                } else {
                    grandparent.getChildren().set(1, node);
                }
            } else {
                root = node;
            }
        }
    }

    private void rotateRight(NodeT2 node) {
        NodeT2 parent = getParent(node);
        NodeT2 grandparent = getParent(parent);
        if (parent != null) {
            NodeT2 newParent = node.getChildren().isEmpty() ? null : node.getChildren().get(1);
            if (!parent.getChildren().isEmpty()) {
                parent.getChildren().set(0, newParent);
            } else {
                parent.getChildren().add(newParent);
            }
            if (newParent != null) node.getChildren().set(1, parent);
            if (grandparent != null) {
                if (grandparent.getChildren().getFirst() == parent) {
                    grandparent.getChildren().set(0, node);
                } else {
                    grandparent.getChildren().set(1, node);
                }
            } else {
                root = node;
            }
        }
    }

    public NodeT2 getRoot() {
        return root;
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(NodeT2 node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R---- ");
                indent += "   ";
            } else {
                System.out.print("L---- ");
                indent += "|  ";
            }

            System.out.println(node.getKeys() + " (" + node.getColor() + ")");

            List<NodeT2> children = node.getChildren();
            for (int i = 0; i < children.size(); i++) {
                printTree(children.get(i), indent, i == children.size() - 1);
            }
        }
    }
}