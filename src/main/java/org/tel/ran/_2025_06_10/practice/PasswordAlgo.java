package org.tel.ran._2025_06_10.practice;

public class PasswordAlgo {

    //public static AbstractConverter converter = new CustomPasswordConverter();
    public static AbstractConverter converter = new ReversePasswordConverterConverter();
    // public static AbstractConverter converter = new BCryptConverter();

    public static void main(String[] args) {
        String password = "hello";
        String passwordEncoded = null;
        String passwordDecoded = null;
        if (converter instanceof PasswordEncoder conv) {
            passwordEncoded = encodePassword(conv, password);
            System.out.println("Encoded " + passwordEncoded);
        }
        if (converter instanceof PasswordDecoder conv) {
            passwordDecoded = decodePassword(conv, passwordEncoded);
            System.out.println("Decoded " + passwordDecoded);
        }
    }


    private static String encodePassword(PasswordEncoder converter, String original) {
        return converter.encode(original);
    }

    private static String decodePassword(PasswordDecoder converter, String encoded) {
        return converter.decode(encoded);
    }
}

