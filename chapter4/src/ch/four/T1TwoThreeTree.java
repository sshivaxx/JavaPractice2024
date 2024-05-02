package ch.four;
public class T1TwoThreeTree { //3.3.23
    private NodeT1 root;

    public void TwoThreeTree() {
        root = null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new NodeT1();
            root.getKeys().add(key);
        } else {
            insertRecursive(root, key);
        }
    }

    private void insertRecursive(NodeT1 nodeT1, int key) {
        if (nodeT1.getKeys().size() == 2) {  // 3-node
            if (key < nodeT1.getKeys().get(0)) {
                insertRecursive(nodeT1.getChildren().getFirst(), key);
            } else if (key > nodeT1.getKeys().get(1)) {
                insertRecursive(nodeT1.getChildren().get(2), key);
            } else {
                insertRecursive(nodeT1.getChildren().get(1), key);
            }
        } else if (nodeT1.getKeys().size() == 1) {  // 2-node
            if (key < nodeT1.getKeys().getFirst()) {
                insertRecursive(nodeT1.getChildren().getFirst(), key);
            } else {
                insertRecursive(nodeT1.getChildren().get(1), key);
            }
        } else {  // Leaf node
            nodeT1.getKeys().add(key);
            nodeT1.getKeys().sort(null);
        }
    }

    public double averagePathLength() {
        int totalPathLength = calculatePathLength(root, 1);
        int totalKeys = countKeys(root);
        return (double) totalPathLength / totalKeys;
    }

    private int calculatePathLength(NodeT1 nodeT1, int depth) {
        if (nodeT1 == null) {
            return 0;
        }

        int pathLength = depth;
        for (NodeT1 child : nodeT1.getChildren()) {
            pathLength += calculatePathLength(child, depth + 1);
        }

        return pathLength;
    }

    private int countKeys(NodeT1 nodeT1) {
        if (nodeT1 == null) {
            return 0;
        }

        int count = nodeT1.getKeys().size();
        for (NodeT1 child : nodeT1.getChildren()) {
            count += countKeys(child);
        }

        return count;
    }
}
