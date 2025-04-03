package org.tel.ran._2025_04_03.mainClass;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Дан список
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1, 100));
        }
        System.out.println(list);
        System.out.println(findMax(list));
        System.out.println(findMin(list));
        System.out.println(sumMaxAndMin(list));
        System.out.println(findMaxDuplicate(list));
        System.out.println(findMaxDuplicate2(list));

        // ------- OPTIONAL -------

        Optional<String> optional = Optional.of("Hello");
        // Выбросить исключение, если Optional содержит null
        String s = optional.orElseThrow();
        System.out.println(s);

        // Задать значение по-умолчанию, если внутри null
        optional = Optional.empty();
        s = optional.orElse("Bye");
        System.out.println(s);

        // Проверить, есть ли внутри значение
        System.out.println(optional.isPresent());

        // Проверить, нет ли внутри значения
        System.out.println(optional.isEmpty());

        // Сделать что-то, если есть значение
        optional = Optional.of("Hello");
        optional.ifPresent(System.out::println);

        // Преобразовать
        optional = Optional.of("425.567");
        System.out.println(optional.map(Double::parseDouble).orElse(0.0));
        optional = Optional.empty();
        System.out.println(optional.map(Double::parseDouble).orElse(0.0));

    }

    //Задача 1: Верните самое большое число списка с помощью стрима
    public static int findMax(List<Integer> list) {
        return list.stream().max(Integer::compare).orElseThrow();
    }

    public static int findMin(List<Integer> list) {
        return list.stream()
                .min(Integer::compare)
                .orElseThrow();
    }

    //Задача 2: Верните сумму самого большого и самого маленького числа списка
    public static int sumMaxAndMin(List<Integer> list) {
        return findMax(list) + list.stream().min(Integer::compare).orElseThrow();
    }

    //Задача 3: Верните самое большое продублированное число. Если дубликатов нет, то верните 0
    public static int findMaxDuplicate(List<Integer> list) {
        return list.stream()
                .filter(n -> Collections.frequency(list, n) > 1)
                .max(Integer::compare)
                .orElse(0);
    }

    public static int findMaxDuplicate2(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .max(Integer::compare)
                .orElse(0);
    }

    public static int findMaxDuplicate3(List<Integer> list) {
        Set<Integer> temp = new HashSet<>();
        return list.stream()
                .filter(i -> !temp.add(i))
                .max(Integer::compare)
                .orElse(0);
    }
}
