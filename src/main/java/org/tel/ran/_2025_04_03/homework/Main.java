package org.tel.ran._2025_04_03.homework;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Task 1. Фильтрация списка чисел
        // Дан список целых чисел: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
        // TODO: Используя Stream API, оставьте только четные числа и выведите их на экран.
        List<Integer> task1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Task 2. Преобразование списка строк
        // Дан список строк: ["apple", "banana", "cherry", "date"].
        // TODO: Преобразуйте все строки в верхний регистр и выведите результат.
        List<String> task2 = List.of("apple", "banana", "cherry", "date");

        // Task 3. Подсчет количества элементов
        // Дан список чисел: [3, 5, 7, 9, 11, 15, 18, 21].
        // TODO: Подсчитайте, сколько в списке чисел больше 10, используя Stream API.
        List<Integer> task3 = List.of(3, 5, 7, 9, 11, 15, 18, 21);

        // Task 4. Объединение строк в одну
        // Дан список строк: ["Java", "Stream", "API", "Example"].
        // TODO: Объедините все строки в одну, используя запятую в качестве разделителя (Java, Stream, API, Example).
        List<String> task4 = List.of("Java", "Stream", "API", "Example");

        // Task 5. Поиск максимального значения
        // Дан список чисел: [23, 45, 12, 67, 34, 89, 90, 56].
        // TODO: Найдите максимальное значение с помощью Stream API.
        List<Integer> task5 = List.of(23, 45, 12, 67, 34, 89, 90, 56);

        // Task 6. Группировка по длине строк
        // Дан список строк: ["one", "three", "five", "seven", "eight", "ten"].
        // TODO: Сгруппируйте строки по их длине и выведите результат в виде Map >.
        List<String> task6 = List.of("one", "three", "five", "seven", "eight", "ten");

        // Task 7. Поиск второго по величине числа
        // Дан список чисел: [10, 5, 8, 20, 15, 25, 30].
        // TODO: Найдите второе по величине число, используя Stream API.
        List<Integer> task7 = List.of(10, 5, 8, 20, 15, 25, 30);

        // Task 8. Частотный анализ символов в строке
        // Дана строка "stream api in java".
        // TODO: Подсчитайте, сколько раз встречается каждый символ (игнорируя пробелы),и выведите результат в виде Map.
        String task8 = "stream api in java";

        // Task 9. Даны два списка:
        // List list1 = Arrays.asList("a", "b", "c");
        // List list2 = Arrays.asList("d", "e", "f");
        // TODO: Объедините их в один список с помощью Stream API.
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("d", "e", "f");

        // Task 10. Поиск самого длинного слова
        // Дан список строк: ["elephant", "cat", "butterfly", "dog", "dolphin"].
        // Найдите самое длинное слово, используя Stream API.
        List<String> task10 = List.of("elephant", "cat", "butterfly", "dog", "dolphin");
    }

    public static
}
