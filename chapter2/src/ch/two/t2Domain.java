package ch.two;
public class t2Domain implements Comparable<t2Domain> { //2.5.14
    private final String name;

    public t2Domain(String name) {
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
    public int compareTo(t2Domain other) {
        return getReverseName().compareTo(other.getReverseName());
    }
}