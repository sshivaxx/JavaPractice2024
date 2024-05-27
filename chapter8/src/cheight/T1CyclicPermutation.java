package cheight;

public class T1CyclicPermutation {
    public static boolean isCyclicPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }
}
