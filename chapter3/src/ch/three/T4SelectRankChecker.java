package ch.three;

public class T4SelectRankChecker {
    public static boolean checkSelectRank(Node root) {
        int size = countNodes(root);
        for (int i = 0; i < size; i++) {
            int selectedKey = select(root, i);
            int rank = rank(root, selectedKey);
            if (i != rank) {
                return false;
            }
        }

        return checkKeySelectRank(root);
    }

    private static int countNodes(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private static int select(Node node, int rank) {
        if (node == null) {
            return -1; // Возвращаем -1 в случае ошибки
        }

        int leftSize = countNodes(node.left);
        if (rank < leftSize) {
            return select(node.left, rank);
        } else if (rank > leftSize) {
            return select(node.right, rank - leftSize - 1);
        } else {
            return node.key;
        }
    }

    private static int rank(Node node, int key) {
        if (node == null) {
            return 0;
        }

        if (key < node.key) {
            return rank(node.left, key);
        } else if (key > node.key) {
            return 1 + countNodes(node.left) + rank(node.right, key);
        } else {
            return countNodes(node.left);
        }
    }

    private static boolean checkKeySelectRank(Node node) {
        if (node == null) {
            return true;
        }

        int selectedKey = select(node, rank(node, node.key));
        if (node.key != selectedKey) {
            return false;
        }

        return checkKeySelectRank(node.left) && checkKeySelectRank(node.right);
    }
}
