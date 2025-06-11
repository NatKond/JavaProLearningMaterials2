package org.tel.ran._2025_06_10.practice;

public class CustomPasswordConverter extends AbstractConverter implements PasswordEncoder, PasswordDecoder {//PasswordConverter {

    @Override
    public String encode(String original) {
        return original.toUpperCase();
    }

    @Override
    public String decode(String encoded) {
        return encoded.toLowerCase();
    }
}
