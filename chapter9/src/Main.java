/*TASK1 5.5.8 стр.762
Кодирование по длинам серий работает хорошо для строк, содержащих длинные последовательности одного и того же символа.
Однако в случае строк вида "ababab..." этот метод не будет эффективным, так как нет длинных последовательностей
одинаковых символов.
Пример:
Строка: ab
RLE: 1a1b (4 символа)
Строка: abab
RLE: 1a1b1a1b (8 символов)
Строка: ababab
RLE: 1a1b1a1b1a1b (12 символов)
Строка: abababab
RLE: 1a1b1a1b1a1b1a1b (16 символов)
В данном случае оригинальная строка и закодированная строка имеют одинаковую длину, что делает коэффициент
сжатия равным 1.

Кодирование Хаффмана
Для строк "ababab..." частоты символов равны, что приводит к созданию равнозначных кодов для каждого символа.
Пример:
Частоты: a: 0.5, b: 0.5
Дерево Хаффмана:
a: 0
b: 1
Кодирование:
Строка: ab
Huffman: 01 (2 бита)
Строка: abab
Huffman: 0101 (4 бита)
Строка: ababab
Huffman: 010101 (6 бита)
Строка: abababab
Huffman: 01010101 (8 бита)
Здесь тоже оригинальная строка и закодированная строка имеют одинаковую длину, что делает коэффициент сжатия равным 1.

LZW-кодирование
LZW-кодирование эффективно для строк с повторяющимися подстроками. Построим таблицу кодирования для строк "ababab...".
Пример:
Строка: ab
LZW: a(97), b(98)
Строка: abab
LZW: a(97), b(98), ab(256)
Строка: ababab
LZW: a(97), b(98), ab(256), aba(257)
Строка: abababab
LZW: a(97), b(98), ab(256), aba(257), abab(258)
Кодирование:
Строка: ab
LZW: 97 98 (2 символа)
Строка: abab
LZW: 97 98 256 (3 символа)
Строка: ababab
LZW: 97 98 256 257 (4 символа)
Строка: abababab
LZW: 97 98 256 257 258 (5 символов)
Здесь коэффициент сжатия можно определить, сравнив длину закодированной строки с оригинальной.
Коэффициент сжатия в виде функции от M
        Для строки, состоящей из N повторений "ab" (общая длина строки 2N):
RLE: Длина закодированной строки остается 2N, коэффициент сжатия = 1.
Хаффман: Длина закодированной строки остается 2N бит, коэффициент сжатия = 1.
LZW: Длина закодированной строки примерно равна N + 1 (так как каждый новый уникальный блок добавляет
один символ в кодовую таблицу).
Коэффициент сжатия для LZW:2N/(N+1)

Таким образом, LZW-кодирование показывает лучший коэффициент сжатия для строк вида "ababab...".*/

/*TASK2 5.2.21 стр.763
    Построение дерева Хаффмана:
        Символы с наименьшими частотами (или вероятностями) объединяются на самых глубоких уровнях дерева.
        На каждом шаге построения дерева два символа (или поддерева) с наименьшими частотами объединяются в новое поддерево.

    Структура дерева:
        Пусть в дереве Хаффмана есть два самых длинных пути (кодовые последовательности) к символам aa и bb.
        Пусть длина этих путей равна dd.

    Гипотеза: Длины двух самых длинных кодовых последовательностей в дереве Хаффмана равны.

    Доказательство от противного:
        Предположим, что это не так, то есть существует путь длины dd к символу aa и путь длины d′d′ к символу bb, где d′<dd′<d.
        Если бы это было так, то символ aa был бы объединён с другим символом или поддеревом раньше, чем символ bb.

    Объединение на самых глубоких уровнях:
        Однако, в процессе построения дерева Хаффмана символы объединяются с другими символами или поддеревьями с наименьшими частотами.
        Это означает, что все символы, объединённые на самом глубоком уровне, имели одинаковые частоты и были объединены в одно и то же время.

    Заключение:
        Следовательно, если бы у нас был путь длины dd к символу aa, то любой другой символ, объединённый на том же шаге, имел бы путь той же длины dd.
        Таким образом, если есть два самых длинных пути в дереве, их длины должны быть одинаковыми.

 */

/* TASK3 5.2.23 стр.763
Применение Хаффмана к 5-битовым символам
    Новый алфавит:
        Новый алфавит состоит из 32 возможных 5-битовых символов (от 00000 до 11111).
    Частота символов:
        Рассчитаем частоты каждого 5-битового символа в полученной строке:
            Предположим, что частоты символов такие:
                01001: 1
                10010: 1
                01110: 1
                00000: 1 (если было дополнение)
    Построение нового дерева Хаффмана:
        Построим новое дерево Хаффмана для этих 5-битовых символов.
    Новое кодирование:
        Применим новое кодирование Хаффмана к строке из 5-битовых символов.

Анализ результата
    Эффективность нового кодирования:
        Новый результат кодирования будет основан на частотах 5-битовых символов.
        Если частоты 5-битовых символов равномерны (что часто бывает в этом случае), то кодирование
        Хаффмана не приведет к значительному сжатию.
        В худшем случае, если все 5-битовые символы встречаются одинаково часто, то длина
        закодированной строки может даже увеличиться из-за дополнительных накладных расходов.
    Потенциальное увеличение размера:
        В случае равномерного распределения 5-битовых символов, кодирование Хаффмана даст коды
        равной длины для каждого символа, что не даст значительного сжатия.
        Дополнение до кратности 5 может также добавить лишние биты, которые не будут сжаты.

 */

import chnine.T4Rle;

public class Main {
    public static void main(String[] args) {
        byte[] input = {1, 2, 2, 3, 3, 3, 1, 1, 1, 1};
        byte[] compressed = T4Rle.compress(input);
        byte[] decompressed = T4Rle.expand(compressed);

        System.out.println("Input: " + toHexString(input));
        System.out.println("Compressed: " + toHexString(compressed));
        System.out.println("Decompressed: " + toHexString(decompressed));
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}