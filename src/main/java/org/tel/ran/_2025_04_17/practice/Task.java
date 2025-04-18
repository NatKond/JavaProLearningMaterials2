package org.tel.ran._2025_04_17.practice;

import java.util.regex.Pattern;

public class Task {

    public static void main(String[] args) {
        String regex = "\\d{3}[\\s-]?\\d{4}";
        System.out.println(Pattern.matches(regex, "123 4267"));
        System.out.println(Pattern.matches(regex, "123-4267"));

        PhoneChecker phoneChecker = new PhoneChecker();
        System.out.println(phoneChecker.isValidPhoneNumber("123 4267"));
        System.out.println(phoneChecker.isValidPhoneNumber("123-4267"));
        System.out.println(phoneChecker.isValidPhoneNumber("12-4267"));
    }
}
