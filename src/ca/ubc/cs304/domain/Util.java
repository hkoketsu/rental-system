package ca.ubc.cs304.domain;

import java.util.Random;

public class Util {
    private static Random r = new Random();

    public static String generateConfirmationNumber() {
        return "cf" + randomDigit() + randomLowercaseLetter() + randomDigit() + randomDigit() + randomDigit() + randomLowercaseLetter() + randomDigit();
    }

    public static String generateRentalId() {
        return "r" + randomDigit() + randomLowercaseLetter() + randomDigit() + randomDigit() + randomDigit() + randomLowercaseLetter() + randomDigit();
    }

    private static int randomDigit() {
        return r.nextInt(9) + 1;
    }

    private static char randomLowercaseLetter() {
        return (char)(r.nextInt('z' - 'a') + 'a');
    }

    private static char randomUppercaseLetter() {
        return (char)(r.nextInt('Z' - 'A') + 'A');
    }
}
