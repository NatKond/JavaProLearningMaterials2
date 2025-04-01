package org.tel.ran._2025_04_01.mainClass;

import org.tel.ran._2025_04_01.mainClass.entity.Address;
import org.tel.ran._2025_04_01.mainClass.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Vasilii", "Almaty")
                .setPatronymic("Vasil'evich")
                .setPostalCode("12514")
                .setSettlement("Almaty");

        System.out.println("person = " + person);

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            personList.add(new Person("firstName" + UUID.randomUUID(),
                    "settlement" + UUID.randomUUID()));
            if (i % 3 == 0) {
                personList.add(new Person("Unknown", "settlement" + UUID.randomUUID()));
            }
        }

        List<Person> unknownPersons = new ArrayList<>();
        for (Person person1 : personList) {
            if (person1.getFirstName().matches("Unknown.*")) {
                unknownPersons.add(person1);
            }
        }

        List<Person> unknowns = personList.stream().filter(p -> p.getFirstName().matches("Unknown.*")).toList();
        List<?> unknownsSettlements = personList.stream().filter(p -> p.getFirstName().matches("Unknown.*")).map(Person::getSettlement).toList();
        System.out.println("unknownsSettlements = " + unknownsSettlements);
        List<?> settlements = personList.stream().map(Person::getSettlement).toList();
        System.out.println("settlements = " + settlements);

        //Реализуйте класс Address, имеющий 3 поля (String street, int houseNumber, Person owner)
        //Создайте поток данных, принимающий List<Address>
        // и возвращающий номера домов на улице "Фруктовая"

        List<Address> addresses = List.of(
                new Address("Fruit Street", 12, new Person("John", "New York")),
                new Address("Garden Avenue", 5, new Person("Emma", "Los Angeles")),
                new Address("Fruit Street", 8, new Person("Liam", "Chicago")),
                new Address("Central Avenue", 25, new Person("Sophia", "Houston")),
                new Address("Forest Road", 14, new Person("James", "Phoenix")),
                new Address("Fruit Street", 19, new Person("Olivia", "Philadelphia")),
                new Address("Lake Street", 3, new Person("William", "San Antonio")),
                new Address("Sunny Boulevard", 7, new Person("Charlotte", "San Diego")),
                new Address("Fruit Street", 22, new Person("Benjamin", "Dallas")),
                new Address("Park Lane", 10, new Person("Alexander", "San Jose"))
        );

        String streetRegex = "Fruit.*";
        List<?> houseNumbers = addresses.stream()
                //       .sorted(Comparator.comparingInt(Address::getHouseNumber))
                .sorted(((a1, a2) -> Math.max(a1.getHouseNumber(), a2.getHouseNumber())))
                .filter(a -> a.getStreet().matches(streetRegex))
                .peek(System.out::println)
                .map(Address::getHouseNumber)
                // .limit(3)
                // .skip(1)
                .toList();
        System.out.println("houseNumbers.stream().findFirst().orElseThrow() = " + houseNumbers.stream().findFirst().orElseThrow());
        System.out.println("houseNumbers = " + houseNumbers);

    }
}