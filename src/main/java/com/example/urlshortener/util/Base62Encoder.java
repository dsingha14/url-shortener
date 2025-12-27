package com.example.urlshortener.util;

public class Base62Encoder {
    private static final String BASE62 =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(long number) {

        StringBuilder result = new StringBuilder();

        while (number > 0) {
            int remainder = (int) (number % 62);
            result.append(BASE62.charAt(remainder));
            number = number / 62;
        }

        return result.reverse().toString();
    }
}
