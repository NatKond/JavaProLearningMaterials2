package org.tel.ran._2025_06_10.practice;

public class ReversePasswordConverterConverter extends AbstractConverter implements PasswordEncoder, PasswordDecoder {//PasswordConverter {
    @Override
    public String encode(String original) {
        return new StringBuilder(original).reverse().toString();
    }

    @Override
    public String decode(String encoded) {
        return new StringBuilder(encoded).reverse().toString();
    }
}
