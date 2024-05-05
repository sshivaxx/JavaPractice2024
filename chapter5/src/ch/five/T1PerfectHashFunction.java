package ch.five;
//3.4.4
public class T1PerfectHashFunction {
    public static void findPerfectHashFunction(String word) {
        int[] indexes = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            indexes[i] = c - 'A' + 1;
        }

        int a = 1;
        int m = indexes.length + 1;

        while (true) {
            boolean[] hashSet = new boolean[m];
            boolean isCollisionFree = true;

            for (int index : indexes) {
                int hashValue = ((a % m) * index) % m;

                if (hashValue < 0) {
                    hashValue += m;
                }

                if (hashSet[hashValue]) {
                    isCollisionFree = false;
                    break;
                }

                hashSet[hashValue] = true;
            }

            if (isCollisionFree) {
                System.out.println("Values for perfect hash function are found:");
                System.out.println("a = " + a + ", m = " + m);
                return;
            }

            a++;
            m = indexes.length + 1;
        }
    }
}
