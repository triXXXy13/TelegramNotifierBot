package com.thebytefox.telegram.util;

import java.util.List;

public final class ParsingUtil {
    private ParsingUtil() {}

    /**
     * Parses input text into hours and minutes
     *
     *  1 -> 1:00
     *  12 -> 12:00
     *  123 -> 1:23
     *  1234 -> 12:34
     *  12:34 -> 12:34
     *
     *  25 -> IllegalArgumentException
     *  10:62 -> IllegalArgumentException
     *
     * @param text
     * @return List of hours and minutes
     */
    public static List<Integer> getTime(String text) {
        int hours = 0;
        int minutes = 0;
        int len = text.length();

        if (text.contains(":")) {
            int delimiter = text.indexOf(":");
            hours = Integer.parseInt(text.substring(0, delimiter));
            minutes = Integer.parseInt(text.substring(++delimiter));
        } else {
            if (len > 4) {
                throw new IllegalArgumentException();
            } else if (len == 1 || len == 3) {
                hours = Integer.parseInt(text.substring(0, 1));
                if (len == 3) {
                    minutes = Integer.parseInt(text.substring(1));
                }
            } else if (len == 2) {
                hours = Integer.parseInt(text);
            } else if (len == 4) {
                hours = Integer.parseInt(text.substring(0, 2));
                minutes = Integer.parseInt(text.substring(2));
            }
        }

        if (hours > 24 || hours < 0 || minutes < 0 || minutes > 60) {
            throw new IllegalArgumentException();
        }

        return List.of(hours, minutes);
    }
}
