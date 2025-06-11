package org.tel.ran._2025_06_10.practice;

public class BCryptConverter extends AbstractConverter implements PasswordEncoder {
    @Override
    public String encode(String original) {
        return new StringBuilder(original).reverse().toString();
    }

//    @Override
//    public String decode(String encoded) {
//        throw new UnsupportedOperationException("Method does not support decode");
//    }
}
