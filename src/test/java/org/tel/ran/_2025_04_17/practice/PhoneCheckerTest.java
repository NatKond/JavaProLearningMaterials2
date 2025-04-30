package org.tel.ran._2025_04_17.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.tel.ran._2025_04_17.practice.PhoneChecker;

import static org.junit.jupiter.api.Assertions.*;

class PhoneCheckerTest {
    private PhoneChecker phoneChecker = new PhoneChecker();

    //1234567 true
    //123 4567 true
    //123-4567 true

    //"" false
    //null false
    //12345-67 false
    //2323232323232323232323 false

    @ParameterizedTest
    @ValueSource(strings = {"1234567", "123 4567", "123-4567"})
    void testPhoneCheckerWhenNumberIsCorrectWithParam(String number){
        assertTrue(phoneChecker.isValidPhoneNumber(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "12345-67", "2323232323232323232323", "123", "sdfdsgdfghdfghfgh"})
    @NullAndEmptySource
    void testPhoneCheckerWhenNumberIsIncorrectWithParam(String number){
        assertFalse(phoneChecker.isValidPhoneNumber(number));
    }

    /*
    @Test
    void testPhoneCheckerWhenNumberIsCorrect(){
        String number = "1234567";
        PhoneChecker phoneChecker = new PhoneChecker();
        boolean result = phoneChecker.isValidPhoneNumber(number);
        assertTrue(result);
    }

    @Test
    void testPhoneCheckerWhenNumberIsCorrectWithSpace(){
        String number = "123 4567";
        PhoneChecker phoneChecker = new PhoneChecker();
        boolean result = phoneChecker.isValidPhoneNumber(number);
        assertTrue(result);
    }

    @Test
    void testPhoneCheckerWhenNumberIsCorrectWithHyphen(){
        String number = "123-4567";
        PhoneChecker phoneChecker = new PhoneChecker();
        boolean result = phoneChecker.isValidPhoneNumber(number);
        assertTrue(result);
    }
    */
}