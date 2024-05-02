package ch.four;
import java.util.ArrayList;
import java.util.List;

public class NodeT2 {
    private final List<Integer> keys;
    private final List<NodeT2> children;
    private Color color;

    public NodeT2() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        color = Color.RED;
    }

    public List<Integer> getKeys() {
        return keys;
    }

    public List<NodeT2> getChildren() {
        return children;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
