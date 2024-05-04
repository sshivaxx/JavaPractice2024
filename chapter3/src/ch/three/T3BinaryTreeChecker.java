package ch.three;

public class T3BinaryTreeChecker {

    public static boolean isBinaryTree(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.key < min || node.key > max) {
            return false;
        }

        return isBinaryTree(node.left, min, node.key - 1) &&
                isBinaryTree(node.right, node.key + 1, max);
    }
}
