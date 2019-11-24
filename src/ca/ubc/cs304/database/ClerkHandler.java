package ca.ubc.cs304.database;

import ca.ubc.cs304.database.DatabaseConnectionClerkHandler;
import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.RentalReceipt;
import ca.ubc.cs304.model.RentalReport;
import ca.ubc.cs304.model.ReturnReceipt;
import ca.ubc.cs304.model.ReturnReport;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClerkHandler {

    private DatabaseConnectionHandler cdh;
    private DatabaseConnectionClerkHandler dcch;

    public ClerkHandler(DatabaseConnectionHandler cdh, DatabaseConnectionClerkHandler dcch) {
        this.cdh = cdh;
        this.dcch = dcch;
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
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        Date curdate = java.sql.Date.valueOf(formatted);

        RentalReport report = dcch.getRentalReport(curdate);

        return report;
    }

    public RentalReport generateBranchRentalReport(String branchLocation, String branchCity) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        Date curdate = java.sql.Date.valueOf(formatted);

        RentalReport report = dcch.getBranchRentalReport(curdate, branchLocation, branchCity);

        return report;
    }

    public ReturnReport generateReturnReport() {
        return null;
    }

    public ReturnReport generateBranchReturnReport(String branchLocation, String branchCity) {
        return null;
    }


}
