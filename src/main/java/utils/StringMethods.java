package utils;

import java.text.Normalizer;

public class StringMethods {

    public static boolean isEmpty(String string) {
        return string.replace(" ", "").isEmpty();
    }

    public static boolean isNotEmpty(String string) {
        return !string.replace(" ", "").isEmpty();
    }

    public static String removeAccents(String input) {
        if (input == null) return null;
        return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    public static String removeSpaces(String input) {
        if (input == null) return null;
        return input.replaceAll(" ", "");
    }
}
