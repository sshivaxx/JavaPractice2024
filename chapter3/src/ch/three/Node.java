package ch.three;

public class Node {
    int key;
    public Node left;
    public Node right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
