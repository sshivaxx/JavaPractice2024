package chnine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class T4Rle {
    private static final int BLOCK_SIZE = 3; // Фиксированная длина кодирования

    public static byte[] compress(byte[] input) {
        // Формирование алфавита
        StringBuilder alphaBuilder = new StringBuilder();
        Map<Byte, Integer> charCount = new HashMap<>();
        for (byte b : input) {
            if (!charCount.containsKey(b)) {
                charCount.put(b, 1);
                alphaBuilder.append((char) (b & 0xFF));
            } else {
                charCount.put(b, charCount.get(b) + 1);
            }
        }
        String alpha = alphaBuilder.toString();
        int alphaLength = alpha.length();

        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            // Запись алфавита в битовый поток
            output.write(alphaLength);
            output.write(alpha.getBytes());

            int i = 0;
            while (i < input.length) {
                byte current = input[i];
                int count = 1;
                while (i + 1 < input.length && input[i + 1] == current) {
                    count++;
                    i++;
                }
                output.write(alpha.indexOf(current));
                output.write(count);
                i++;
            }

            return output.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] expand(byte[] input) {
        try (ByteArrayInputStream in = new ByteArrayInputStream(input)) {
            int alphaLength = in.read();
            byte[] alphaBytes = new byte[alphaLength];
            in.read(alphaBytes);
            String alpha = new String(alphaBytes);

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            while (in.available() >= BLOCK_SIZE) {
                int charIndex = in.read();
                int count = in.read();
                for (int i = 0; i < count; i++) {
                    output.write(alpha.charAt(charIndex));
                }
            }
            return output.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}