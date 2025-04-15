package org.tel.ran._2025_04_15.mainClass;

import org.tel.ran._2025_04_15.practice.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Task {
    public static final Logger LOGGER = new Logger("files/log.txt");

    public static void main(String[] args) {
        AbstractUtil util = new Util();


        List<Integer> integers = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> evenIntegers = util.filter(integers,(Integer x) -> x % 2 == 0);
        System.out.println("evenIntegers = " + evenIntegers);

        System.out.println("util.compare(5, 2, Comparator.naturalOrder()) = " + util.compare(5, 2, Comparator.naturalOrder()));

        User userOrigin = new User("id_001", "login_john", 1234, 567890);
        System.out.println("userOrigin = " + userOrigin);
        //util.serialize(userOrigin);

        User userCopy = util.deserialize();
        System.out.println("userCopy = " + userCopy);

        Predicate<Integer> origin = (Integer x) -> x == 5;
        Predicate<Integer> inverse = util.negate(origin);

        System.out.println("origin.test(5) = " + origin.test(5));
        System.out.println("inverse.test(5) = " + inverse.test(5));

    }
}
