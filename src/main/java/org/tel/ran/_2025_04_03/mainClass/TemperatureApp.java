package org.tel.ran._2025_04_03.mainClass;

import java.util.*;

public class TemperatureApp {
    private final static int LIMIT = 3;
    public static void main(String[] args) {
        // У Вас есть список List<List<Integer>> measurements, где каждый список -
        // это измерения температуры за день. В день не более 10 измерений и
        // температура колеблется от -30 до +30.

        List<List<Integer>> measurements = List.of(
                List.of(-25, -20, -15, -22, -15),
                List.of(-13, -6, -8, -10),
                List.of(-10, -8, -5, -6),
                List.of(-5, 0, 3, -2),
                List.of(0, 4, 5, 0, -1),
                List.of(-3, -2, 0, 5),
                List.of(7, 9, 5, 8),
                List.of(14, 13, 11, 10),
                List.of(12, 15, 9, 7),
                List.of(11, 13, 14),
                List.of(15, 20, 18),
                List.of(20, 25, 30, 22)
        );

        System.out.println(measurements);

        System.out.println(findMaxMin(measurements));

    }

    /**
     * Найдите 3 самых низких измерения и 3 самых высоких за все дни
     * @param measurements
     * @return
     */
    public static List<List<Integer>> findMaxMin (List<List<Integer>> measurements){
        return List.of (
                measurements.stream()
                        .flatMap(Collection::stream)
                        .sorted()
                        .limit(LIMIT)
                        .toList(),
                measurements.stream()
                        .flatMap(Collection::stream)
                        .sorted(Comparator.reverseOrder())
                        .limit(LIMIT)
                        .toList());
    }

    // Список заменить на List<Map<Integer, List<Integer>>>,
    // где Map<Номер дня, List<Значения температуры>>. Вернуть первые 3 дня,
    // где средняя температура превышает 0 градусов

    public static List<Map<Integer, List<Integer>>> convertToMap(List<List<Integer>> measurements){
        return new ArrayList<>();
    }
}
