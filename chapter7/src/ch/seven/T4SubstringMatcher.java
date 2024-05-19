package ch.seven;

import java.util.ArrayList;
import java.util.List;

public class T4SubstringMatcher {

    public static void insertWord(T1Tst<List<String>> tst, String word) {
        // Вставка всех суффиксов слова в TST
        for (int i = 0; i < word.length(); i++) {
            String suffix = word.substring(i);
            if (tst.contains(suffix)) {
                tst.put(suffix, new ArrayList<>());
            }
            tst.get(suffix).add(word);
        }
    }

    public static List<String> search(T1Tst<List<String>> tst, String query) {
        List<String> result = tst.get(query);
        return result == null ? new ArrayList<>() : result;
    }
}
