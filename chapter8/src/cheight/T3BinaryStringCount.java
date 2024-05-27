package cheight;

import java.security.SecureRandom;

public class T3BinaryStringCount {
    public static String generateRandomBinaryString(int N) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(N);
        for (int i = 0; i < N; i++) {
            sb.append(random.nextInt(2));
        }
        return sb.toString();
    }

    public static int countOccurrences(String binaryString, int M) {
        int length = binaryString.length();
        if (M > length) {
            return 0;
        }

        String lastMBits = binaryString.substring(length - M);
        int count = 0;

        for (int i = 0; i <= length - M - 1; i++) {
            if (binaryString.substring(i, i + M).equals(lastMBits)) {
                count++;
            }
        }

        return count;
    }
}
