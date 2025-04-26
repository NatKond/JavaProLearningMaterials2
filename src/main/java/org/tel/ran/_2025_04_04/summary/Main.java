package org.tel.ran._2025_04_04.summary;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Задача 1:
        //Дан список предложений:
        List<String> sentences = List.of(
                "Java is cool",
                "Streams are powerful",
                "FlatMap is handy"
        );
        //Разбить предложения на слова и собрать все слова в один список.
        List<?> words1 = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .toList();
        System.out.println(words1);

        //Задача 2
        List<String> paragraphs = List.of(
                "Java streams are very useful",
                "Java FlatMap helps flatten structures",
                "Java Practice makes perfect"
        );
        //Извлечь все слова, преобразовав в нижний регистр и отфильтровав повторы, с помощью flatMap.
        Set<?> words2 = paragraphs.stream()
                .flatMap(paragraph -> Arrays.stream(paragraph.toLowerCase().split(" ")))
                .collect(Collectors.toSet());
        System.out.println(words2);

        //Задача 3
        //Есть два класса:

        //class Order {
        //    int id;
        //    List<Product> products;
        //}
        //
        //class Product {
        //    String name;
        //    double price;
        //}

        //И список заказов:
        List<Order> orders = List.of(
                new Order(1, List.of(new Product("Pen", 1.5), new Product("Notebook", 3.0))),
                new Order(2, List.of(new Product("Pencil", 0.5), new Product("Pen", 1.5))),
                new Order(3, List.of(new Product("Notebook", 3.0), new Product("Eraser", 0.75)))
        );
        //Получить уникальный список названий продуктов, заказанных хотя бы раз
        Set<?> productNames1 = orders.stream()
                .flatMap(order -> order.getProducts().stream().map(Product::getName))
                .collect(Collectors.toSet());

        Set<?> productNames2 = orders.stream()
                .map(o -> o.products)
                .flatMap(Collection::stream)
                .map(p -> p.name)
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);

        System.out.println(productNames1);
        System.out.println(productNames2);

        //Есть список строк:
        List<String> words3 = List.of("apple", "banana", "apple", "orange", "banana", "banana");
        // Используя Stream API, посчитай, сколько раз каждое слово встречается,
        // и сохрани результат в Map<String, Long>.
        Map<String, Long> wordsMap = words3.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(wordsMap);
    }


}


