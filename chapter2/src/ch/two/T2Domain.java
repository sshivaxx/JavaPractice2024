package ch.two;
public class T2Domain implements Comparable<T2Domain> { //2.5.14
    private final String name;

    public T2Domain(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getReverseName() {
        String[] fragments = name.split("\\.");
        StringBuilder reverseName = new StringBuilder();

        for (int i = fragments.length - 1; i >= 0; i--) {
            reverseName.append(fragments[i]);
            if (i != 0) {
                reverseName.append(".");
            }
        }

        return reverseName.toString();
    }

    @Override
    public int compareTo(T2Domain other) {
        return getReverseName().compareTo(other.getReverseName());
    }
}