package ca.ubc.cs304.database;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.RentalReceipt;
import ca.ubc.cs304.model.RentalReport;
import ca.ubc.cs304.model.ReturnReceipt;
import ca.ubc.cs304.model.ReturnReport;

import java.sql.Date;

public class ClerkHandler {

    private DatabaseConnectionHandler cdh;

    public ClerkHandler(DatabaseConnectionHandler cdh) {
        this.cdh = cdh;
    }

    public RentalReceipt rentVehicle() {
        return null;
    }

    public double estimateCost(String carType) {
        return -1;
    }

    public ReturnReceipt returnRental(String rid) {
        return null;
    }

    public RentalReport generateRentalReport() {
        return null;
    }

    public RentalReport generateBranchRentalReport(String branchLocation, String branchCity) {
        return null;
    }

    public ReturnReport generateReturnReport() {
        return null;
    }

    public ReturnReport generateBranchReturnReport(String branchLocation, String branchCity) {
        return null;
    }


}
