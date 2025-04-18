package org.tel.ran._2025_04_17.practice;

import java.util.regex.Pattern;

public class PhoneChecker {

    public boolean isValidPhoneNumber(String number){
        if (number == null){
            return false;
        }

        String regex = "\\d{3}[\\s-]?\\d{4}";
        return Pattern.matches(regex, number);
    }
}
