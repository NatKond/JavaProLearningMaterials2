package org.tel.ran._2025_04_01.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class FruitApp {

    public static double priceThreshold = 2;

    public static char letter = 'e';

    public static int maxLength = 5;

    public static Map<Integer, Predicate<Fruit>> filter = Map.of(
            1, Fruit::isInStock,
            2, f -> f.getPrice() > priceThreshold,
            3, f -> f.getName().charAt(f.getName().length() - 1) == letter,
            4, f -> f.getName().length() > maxLength
    );

    public static void main(String[] args) {
        List<Fruit> fruits = List.of(
                new Fruit(2.5, "Apple", true),
                new Fruit(5, "Pineapple", false),
                new Fruit(3, "Orange", true),
                new Fruit(1, "Kiwi", true),
                new Fruit(1.3, "Banana", true),
                new Fruit(2, "Grape", true),
                new Fruit(4.2, "Mango", false),
                new Fruit(0.8, "Plum", true),
                new Fruit(2.7, "Pear", true),
                new Fruit(3.5, "Cherry", false),
                new Fruit(1.9, "Lime", true),
                new Fruit(2.3, "Peach", true)
        );

        fruits.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Choose a filter:
                1 - available in stock
                2 - price greater than 2
                3 - name ends with "e"
                4 - name is longer than 5 letters
                0 - finish
                """);

        List<Predicate<Fruit>> predicates = new ArrayList<>();
        int answer = scanner.nextInt(); // сканируем ответ с клавиатуры и добавляем предикаты(условия фильтрации) в соотвествии с выбором
        while (answer != 0) { // выход из цикла - окончание ввода предикатов - 0
            predicates.add(filter.get(answer));
            /*
            switch (answer) {
                case 1 -> predicates.add(Fruit::isInStock);
                case 2 -> predicates.add(f -> f.getPrice() > 2);
                case 3 -> predicates.add(f -> f.getName().charAt(f.getName().length() - 1) == 'e');
                case 4 -> predicates.add(f -> f.getName().length() > 5);
            } */
            answer = scanner.nextInt();
        }

        List<Fruit> filteredFruits = filter(fruits, getPredicate(predicates)); // вывод результатов фильтрации с выбраными предикатами(условиями)
        // System.out.println(filteredFruits);
        filteredFruits.forEach(System.out::println);
    }

    // метод для фильтрации списка фруктов
    public static List<Fruit> filter(List<Fruit> fruits, Predicate<Fruit> fruitPredicate) {
        return fruits.stream().filter(fruitPredicate).toList();
    }

    // метод для создания предиката(условия) фильтрации
    public static Predicate<Fruit> getPredicate(List<Predicate<Fruit>> predicates) {
        if (predicates == null || predicates.isEmpty()) {
            throw new IllegalArgumentException("No predicates in the list.");
        }

        Predicate<Fruit> predicate = predicates.getFirst();
        for (int i = 1; i < predicates.size(); i++) {
            predicate = predicate.and(predicates.get(i));
        }
        return predicate;
    }
    /*
    public static List<Fruit> getInStock(List<Fruit> fruits){
        return fruits.stream().filter(Fruit::isInStock).toList();
    }

    public static List<Fruit> getPriceHigher(List<Fruit> fruits, double threshold){
        return fruits.stream().filter(f -> f.getPrice() > threshold).toList();
    }

    public static List<Fruit> getNameEnds(List<Fruit> fruits, char letter){
        return fruits.stream().filter(f -> f.getName().charAt(f.getName().length() - 1) == letter).toList();
    }*/
}
