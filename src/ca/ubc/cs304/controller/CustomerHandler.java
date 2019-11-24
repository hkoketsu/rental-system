package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.CustomerModel;
import ca.ubc.cs304.model.ReservationModel;
import ca.ubc.cs304.model.TimeInterval;
import ca.ubc.cs304.model.VehicleModel;

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
        int numberOfVehicles = dbHandler.numberOfVehiclesNotRented(carType, location, timeInterval);
        //if (timeInterval != null) {
        int numberOfVehiclesWithNoLocation = dbHandler.numberOfVehiclesNotRented(carType, null, timeInterval);
        int numberOfReservedVehicles = dbHandler.numberOfReservedVehicles(carType, timeInterval);
        if (numberOfVehiclesWithNoLocation <= numberOfReservedVehicles) {
            return 0;
           // }
        }
        return numberOfVehicles;
    }

    // any of the arguments can be null
    public VehicleModel[] viewVehicles(String carType, String location, TimeInterval timeInterval) {
        return dbHandler.getVehicles(carType, location, timeInterval);
    }

    public void addCustomerToDatabase(String dlicense, String cellphone, String name, String address) {
        CustomerModel model = new CustomerModel(dlicense, cellphone, name, address);
        dbHandler.insertCustomer(model);
    }

    public boolean isCustomerInDatabase(String cellphone) {
        CustomerModel[] models = dbHandler.getCustomerInfo(cellphone);
        if (models.length == 0) {
            return false;
        } else {
            return true;
        }
    }

    // Returns the confno of the created reservation
    // Gets list of confNo's from database
    // Generates random confNo's until one is created that is not in the database
    public String makeReservation(String carType, String driverLicense, TimeInterval timeInterval) {
        String[] confNoArr = dbHandler.getReservationConfnoInfo();
        List<String> confNoList = Arrays.asList(confNoArr);
        String confNo;
        do {
            confNo = "cf";
            Random random = new Random();
            confNo += random.nextInt(10);
            confNo += this.getRandomLetter();
            confNo += random.nextInt(10);
            confNo += random.nextInt(10);
            confNo += random.nextInt(10);
            confNo += this.getRandomLetter();
            confNo += random.nextInt(10);
        } while (confNoList.contains(confNo));

        ReservationModel model = new ReservationModel(confNo, carType, driverLicense,
                timeInterval.getFromDate(), timeInterval.getFromTime(),
                timeInterval.getToDate(), timeInterval.getToTime());
        dbHandler.insertReservation(model);

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
        String saltStr = salt.toString();
        return saltStr;

    }
}
