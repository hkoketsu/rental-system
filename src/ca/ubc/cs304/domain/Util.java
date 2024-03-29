package ca.ubc.cs304.domain;

import ca.ubc.cs304.database.DatabaseConnectionHandler;

import java.util.Random;

public class Util {
    private static Random r = new Random();
    private DatabaseConnectionHandler dbHandler;

    public Util(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public String generateConfirmationNumber() {
        String confNo;
        DatabaseConnectionHandler handler = new DatabaseConnectionHandler();
        while (true) {
            confNo = "cf" + randomDigit() + randomLowercaseLetter() + randomDigit() +
                    randomDigit() + randomDigit() + randomLowercaseLetter() + randomDigit();
            Reservation reservation = dbHandler.getReservation(confNo);
            if (reservation == null) break;
        }
        return confNo;
    }

    public String generateRentalId() {
        String rentalId;
        DatabaseConnectionHandler handler = new DatabaseConnectionHandler();
        while (true) {
            rentalId = "r" + randomDigit() + randomLowercaseLetter() + randomDigit() + randomDigit()
                    + randomDigit() + randomLowercaseLetter() + randomDigit();
            Rental rental = dbHandler.getRentalInfo(rentalId);
            if (rental == null) break;
        }
        return rentalId;
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
