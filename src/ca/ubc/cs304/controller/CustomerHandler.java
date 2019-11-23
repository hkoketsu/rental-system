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

    private DatabaseConnectionHandler cdh;

    public CustomerHandler (DatabaseConnectionHandler cdh) {
        this.cdh = cdh;
    }

    // any of the arguments can be null
    public int viewNumberOfVehicles(String carType, String location, TimeInterval timeInterval) {
        int numberOfVehicles = cdh.numberOfVehiclesNotRented(carType, location, timeInterval);
        if (timeInterval != null) {
            int numberOfReservedVehicles = cdh.numberOfReservedVehicles(carType, timeInterval);
            if (numberOfVehicles <= numberOfReservedVehicles) {
                return 0;
            }
        }
        return numberOfVehicles;
    }

    // any of the arguments can be null
    public VehicleModel[] viewVehicles(String carType, String location, TimeInterval timeInterval) {
        return cdh.getVehicles(carType, location, timeInterval);
    }

    public void addCustomerToDatabase(String dlicense, String cellphone, String name, String address) {
        CustomerModel model = new CustomerModel(dlicense, cellphone, name, address);
        cdh.insertCustomer(model);
    }

    public boolean isCustomerInDatabase() {
        CustomerModel[] models = cdh.getCustomerInfo();
        if (models.length == 0) {
            return false;
        } else {
            return true;
        }
    }

    // Returns the confno of the created reservation
    // Gets list of confNo's from database
    // Generates random confNo's until one is created that is not in the database
    public String makeReservation(String location, String carType, String name, String cellphone, TimeInterval timeInterval) {
        String[] confNoArr = cdh.getReservationConfnoInfo();
        List<String> confNoList = Arrays.asList(confNoArr);
        String confNo;
        do {
            confNo = this.getSaltString();
        } while (confNoList.contains(confNo));

        ReservationModel model = new ReservationModel(confNo, carType, cellphone,
                timeInterval.getFromDate(), timeInterval.getFromTime(),
                timeInterval.getToDate(), timeInterval.getToTime());
        cdh.insertReservation(model);

        return confNo;
    }


    // from: https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
