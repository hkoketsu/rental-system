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
        return dbHandler.getNumberOfVehiclesNotRented(carType, location, timeInterval);
    }

    public boolean isVehicleAvailable(String vehicleLicense, TimeInterval timeInterval) {
        Vehicle model = dbHandler.getRentedVehicle(vehicleLicense, timeInterval);
        return model != null;
    }

    // any of the arguments can be null
    public List<Vehicle> viewVehicles(String carType, String location, TimeInterval timeInterval) {
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

    public void makeReservation(String confNo, String carType, String driverLicense, TimeInterval timeInterval) {
        Reservation model = new Reservation(confNo, carType, driverLicense, timeInterval);
        dbHandler.putReservation(model);
    }
}
