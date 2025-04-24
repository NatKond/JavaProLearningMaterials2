package org.tel.ran._2025_04_01.homework;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

record Student(String name, Speciality speciality, int year, int age) {
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alex", Speciality.Physics, 1, 21),
                new Student("Rika", Speciality.Biology, 4, 27),
                new Student("Julia", Speciality.Biology, 3, 26),
                new Student("Steve", Speciality.History, 4, 30),
                new Student("Mike", Speciality.Finance, 1, 23),
                new Student("Hinata", Speciality.Biology, 2, 22),
                new Student("Richard", Speciality.History, 1, 19),
                new Student("Kate", Speciality.Psychology, 2, 23),
                new Student("Sergey", Speciality.ComputerScience, 4, 28),
                new Student("Maximilian", Speciality.ComputerScience, 3, 25),
                new Student("Tim", Speciality.ComputerScience, 5, 31),
                new Student("Ann", Speciality.Psychology, 1, 22)
        );
        System.out.println("-".repeat(15) + " getNumberStudentMap " + "-".repeat(15));
        getNumberStudentMap(students).entrySet().forEach(System.out::println);
        System.out.println("-".repeat(15) + " getMapYearAverageAge " + "-".repeat(15));
        System.out.println(getMapYearAverageAge(students));
        System.out.println("-".repeat(15) + " getSpecialityStudentsMap " + "-".repeat(15));
        getSpecialityStudentsMap(students).entrySet().forEach(System.out::println);
        System.out.println("-".repeat(15) + " getSpecialityCountStudentsMap " + "-".repeat(15));
        System.out.println(getSpecialityCountStudentsMap(students));
        System.out.println("-".repeat(15) + " getSpecialityNamesStudentsMap " + "-".repeat(15));
        getSpecialityNamesStudentsMap(students).entrySet().forEach(System.out::println);
        System.out.println("-".repeat(15) + " getSpecialityNamesStudentsMapOlderThan " + "-".repeat(15));
        getSpecialityNamesStudentsMapOlderThan(students, 22).entrySet().forEach(System.out::println);

        System.out.println("-".repeat(15) + " getTwoDimensionalArray(3, 5) " + "-".repeat(15));
        System.out.println(Arrays.deepToString(getTwoDimensionalArray(3, 5)));
        System.out.println("-".repeat(15) + " getMultiples 3 and 7 " + "-".repeat(15));
        System.out.println(Arrays.toString(getMultiples(3, 7, 100)));
        System.out.println("-".repeat(15) + " findSumOfSquares 2, 3, 4, 5" + "-".repeat(15));
        System.out.println(findSumOfSquares(2, 3, 4, 5));

    }

    public static Map<Number, Student> getNumberStudentMap(List<Student> students) {
        return IntStream.range(1, students.size())
                .boxed()
                .collect(Collectors.toMap(Function.identity(), students::get));
    }

    public static Map<Integer, Double> getMapYearAverageAge(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(Student::year, Collectors.mapping(Student::age, Collectors.averagingInt(i -> i))));
    }

    public static Map<Speciality, List<Student>> getSpecialityStudentsMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::speciality,
                        s -> new ArrayList<>(List.of(s)),
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }));
    }

    public static Map<Speciality, Integer> getSpecialityCountStudentsMap(List<Student> students) {
        //return students.stream().collect(Collectors.groupingBy(Student::speciality, Collectors.counting()));

        return students.stream()
                .collect(Collectors.toMap(
                        Student::speciality,
                        s -> 1,
                        Integer::sum));
    }

    public static Map<Speciality, List<String>> getSpecialityNamesStudentsMap(List<Student> students) {
//        return students.stream()
//                .collect(Collectors.toMap(
//                        Student::speciality,
//                        s -> new ArrayList<>(List.of(s.name())),
//                        (oldList, newList) -> {
//                            oldList.addAll(newList);
//                            return oldList;
//                        }));

        return students.stream()
                .collect(Collectors.groupingBy(Student::speciality, Collectors.mapping(Student::name, Collectors.toCollection(ArrayList::new))));
    }

    public static Map<Speciality, List<String>> getSpecialityNamesStudentsMapOlderThan(List<Student> students, int ageThreshold) {
        return students.stream()
                .filter(student -> student.age() > ageThreshold)
                .collect(Collectors.groupingBy(Student::speciality, Collectors.mapping(Student::name, Collectors.toCollection(ArrayList::new))));
    }

    public static int[][] getTwoDimensionalArray(int size1, int size2) {
        int[][] ints = new int[size1][size2];
        IntStream.range(0, ints.length)
                .forEach(i -> IntStream.range(0, ints[i].length)
                        .forEach(j -> ints[i][j] = (i + j)));
        return ints;
    }

    public static int[] getMultiples(int num1, int num2, int range) {
        return IntStream.range(0, range)
                .filter(i -> i % num1 == 0)
                .filter(i -> i % num2 == 0)
                .toArray();
    }

    public static int findSumOfSquares(int... numbers) {
        return Arrays.stream(numbers).map(i -> i * i).peek(i -> System.out.print(i + " ")).sum();
        //return Arrays.stream(numbers).reduce((akk, e) -> akk + e * e).orElse(0);
    }


}
