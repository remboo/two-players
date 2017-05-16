package com.johnremboo;

import java.util.Random;

/**
 * Created by Igor Orekhov on 16.05.17.
 * Generates random messages.
 */
public class MessageGenerator {
    public static String getString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < 6) {
            int index = (int) (rnd.nextFloat() * chars.length());
            builder.append(chars.charAt(index));
        }
        return builder.toString();
    }
}
