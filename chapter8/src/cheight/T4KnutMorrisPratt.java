package cheight;

public class T4KnutMorrisPratt {
    private final int[] lps;
    private final String pattern;
    private int comparisons;

    public T4KnutMorrisPratt(String pattern) {
        this.pattern = pattern;
        this.lps = computeLPSArray(pattern);
        this.comparisons = 0;
    }

    public void search(String text) {
        int M = pattern.length();
        int N = text.length();

        int i = 0; // индекс для text[]
        int j = 0; // индекс для pattern[]
        while (i < N) {
            comparisons++;
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    private int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];
        int len = 0;
        int i = 1;

        lps[0] = 0; // lps[0] всегда 0

        while (i < M) {
            comparisons++;
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public int getComparisons() {
        return comparisons;
    }
}
