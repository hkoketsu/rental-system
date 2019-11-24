package ca.ubc.cs304.service;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Return;
import ca.ubc.cs304.model.RentalReceipt;
import ca.ubc.cs304.model.RentalReport;

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

    public Return returnRental(String rid) {
        return null;
    }

    public RentalReport generateRentalReport() {
        return null;
    }

    public RentalReport generateBranchRentalReport(String branchLocation, String branchCity) {
        return null;
    }

    public Return generateReturnReport() {
        return null;
    }

    public Return generateBranchReturnReport(String branchLocation, String branchCity) {
        return null;
    }


}
