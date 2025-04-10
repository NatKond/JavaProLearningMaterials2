package org.tel.ran._2025_04_03.mainClass;

import java.util.*;

public class PersonApp {
    public static void main(String[] args) {
        Random random = new Random();
        List<List<Person>> enterprise = List.of(
                List.of(new Person("Alice Johnson", 5000),
                        new Person("Bob Smith", 6000),
                        new Person("Charlie Brown", 7000),
                        new Person("David White", 8000)),

                List.of(new Person("Emma Davis", 5500),
                        new Person("Frank Miller", 6200),
                        new Person("Grace Wilson", 7500),
                        new Person("Henry Moore", 5800)),

                List.of(new Person("Ivy Taylor", 5300),
                        new Person("Jack Anderson", 6700),
                        new Person("Kate Thomas", 7100),
                        new Person("Leo Harris", 5900)),

                List.of(new Person("Mia Clark", 5100),
                        new Person("Noah Lewis", 6400),
                        new Person("Olivia Walker", 7300),
                        new Person("Paul Hall", 5700))
        );
        /*
        List<List<Person>> enterprise = List.of(
                List.of(new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)),
                        new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)),
                        new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000))),
                List.of(new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)),
                        new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)),
                        new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000))),
                List.of(new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)),
                        new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)),
                        new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000))),
                List.of(new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)),
                        new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)),
                        new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)))
        );
        */

        // Каждый вложенный список - отдельная компания в рамках холдинга.
        // Верните имя сотрудника с самой высокой заплатой среди всех компаний
        String name = enterprise.stream()
                .flatMap(Collection::stream)
                //.flatMap(list -> list.stream())
                .max(Comparator.comparingInt(Person::getSalary))
                .orElseThrow().getName();
        System.out.println(name);
    }


}
