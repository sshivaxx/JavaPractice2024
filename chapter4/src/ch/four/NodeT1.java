package ch.four;

import java.util.ArrayList;
import java.util.List;

public class Node {
        private final List<Integer> keys;
        private List<Node> children;

        public Node() {
            keys = new ArrayList<>();
            children = new ArrayList<>();
        }

        public List<Integer> getKeys() {
            return keys;
        }

        public List<Node> getChildren() {
            return children;
        }

}
