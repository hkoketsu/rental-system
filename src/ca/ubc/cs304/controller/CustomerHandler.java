package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.TimeInterval;
import ca.ubc.cs304.model.VehicleModel;

public class CustomerHandler {

    private DatabaseConnectionHandler cdh;

    public CustomerHandler (DatabaseConnectionHandler cdh) {
        this.cdh = cdh;
    }
    
    public int viewNumberOfVehicles(String carType, String location, TimeInterval timeInterval) {
        return -1;
    }

    public VehicleModel[] viewVehicles(String carType, String location, TimeInterval timeInterval) {
        return null;
    }

    public void addCustomerToDatabase(String dlicense, String cellphone, String name, String address) {

    }

    public double estimateCost(String carType) {
        return -1;
    }

    // Returns the confno of the created reservation
    public String makeReservation(String location, String carType, String name, String cellphone, TimeInterval timeInterval) {
        return null;
    }
}
