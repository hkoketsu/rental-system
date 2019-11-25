package ca.ubc.cs304.service;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CustomerHandler {

    private DatabaseConnectionHandler dbHandler;

    public CustomerHandler (DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    // any of the arguments can be null
    //
    public int viewNumberOfVehicles(String carType, String location, TimeInterval timeInterval) {
        int numberOfVehicles = dbHandler.getNumberOfVehiclesNotRented(carType, location, timeInterval);
        int numberOfVehiclesWithNoLocation = dbHandler.getNumberOfVehiclesNotRented(carType, null, timeInterval);
        int numberOfReservedVehicles = dbHandler.getNumberOfReservedVehicles(carType, timeInterval);
        if (numberOfVehiclesWithNoLocation <= numberOfReservedVehicles) {
            return 0;
        }
        return numberOfVehicles;
    }

    public boolean isVehicleAvailable(String vehicleLicense, TimeInterval timeInterval) {
        Vehicle model = dbHandler.getRentedVehicle(vehicleLicense, timeInterval);
        return model != null;
    }

    // any of the arguments can be null
    public Vehicle[] viewVehicles(String carType, String location, TimeInterval timeInterval) {
        return dbHandler.getVehicles(carType, location, timeInterval);
    }

    public void addCustomerToDatabase(String dlicense, String cellphone, String name, String address) {
        Customer model = new Customer(dlicense, cellphone, name, address);
        dbHandler.putCustomer(model);
    }

    public boolean isCustomerInDatabase(String dlicense) {
        Customer customer = dbHandler.getCustomer(dlicense);
        return customer != null;
    }

    // Returns the confno of the created reservation
    // Gets list of confNo's from database
    // Generates random confNo's until one is created that is not in the database
    public String makeReservation(String carType, String driverLicense, TimeInterval timeInterval) {
        String[] confNoArr = dbHandler.getReservationConfnoInfo();
        List<String> confNoList = Arrays.asList(confNoArr);
        String confNo;
        do {
            confNo = new Util(dbHandler).generateConfirmationNumber();
//            confNo = "cf";
//            Random random = new Random();
//            confNo += random.nextInt(10);
//            confNo += this.getRandomLetter();
//            confNo += random.nextInt(10);
//            confNo += random.nextInt(10);
//            confNo += random.nextInt(10);
//            confNo += this.getRandomLetter();
//            confNo += random.nextInt(10);
        } while (confNoList.contains(confNo));

        Reservation model = new Reservation(confNo, carType, driverLicense, null, timeInterval);
        dbHandler.putReservation(model);

        return confNo;
    }


    // from: https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    private String getRandomLetter() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 1) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }
}
