package ch.five;
//3.4.23
public class T3ModularHash{
    public static int modularHash(String str) {
        int R = 256;
        int m = 255;
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * R + str.charAt(i)) % m;
        }
        return hash;
    }
}
