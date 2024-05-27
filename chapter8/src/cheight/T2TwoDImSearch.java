package cheight;

public class T2TwoDImSearch {
    public static boolean contains2DPattern(char[][] text, char[][] pattern) {
        int textRows = text.length;
        int textCols = text[0].length;
        int patternRows = pattern.length;
        int patternCols = pattern[0].length;

        // Вычисляем хеш-значение шаблона
        int patternHash = computeHash(pattern);

        // Итерируем по тексту и сравниваем хеш-значения
        for (int i = 0; i <= textRows - patternRows; i++) {
            for (int j = 0; j <= textCols - patternCols; j++) {
                int textHash = computeHash(text, i, j, patternRows, patternCols);
                if (textHash == patternHash && areEqual(text, i, j, pattern)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int computeHash(char[][] matrix) {
        int hash = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                hash = hash * 31 + chars[j];
            }
        }
        return hash;
    }

    private static int computeHash(char[][] text, int startRow, int startCol, int rows, int cols) {
        int hash = 0;
        for (int i = startRow; i < startRow + rows; i++) {
            for (int j = startCol; j < startCol + cols; j++) {
                hash = hash * 31 + text[i][j];
            }
        }
        return hash;
    }

    private static boolean areEqual(char[][] text, int startRow, int startCol, char[][] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[0].length; j++) {
                if (text[startRow + i][startCol + j] != pattern[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
