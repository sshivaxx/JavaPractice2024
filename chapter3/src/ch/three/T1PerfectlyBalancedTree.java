package ch.three;
import java.util.Arrays;

public class T1PerfectlyBalancedTree {
    public static Node balanceKeys(int[] keys) {
        if (keys.length == 0) {
            return null;
        }

        Arrays.sort(keys);
        return constructBalancedTree(keys, 0, keys.length - 1);
    }

    private static Node constructBalancedTree(int[] keys, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(keys[mid]);

        root.left = constructBalancedTree(keys, start, mid - 1);
        root.right = constructBalancedTree(keys, mid + 1, end);

        return root;
    }

    public static void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }
}

