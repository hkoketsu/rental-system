package ca.ubc.cs304.database;


import ca.ubc.cs304.model.*;
import ca.ubc.cs304.model.reports.RentalBranchReport;
import ca.ubc.cs304.model.reports.RentalReport;
import ca.ubc.cs304.model.reports.ReturnBranchReport;
import ca.ubc.cs304.model.reports.ReturnReport;

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

    public RentalBranchReport generateBranchRentalReport(String branchLocation, String branchCity) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        Date curdate = java.sql.Date.valueOf(formatted);

        RentalBranchReport report = dcch.getBranchRentalReport(curdate, branchLocation, branchCity);

        return report;
    }

    public ReturnReport generateReturnReport() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        Date curdate = java.sql.Date.valueOf(formatted);

        ReturnReport report = dcch.getReturnReport(curdate);

        return report;
    }

    public ReturnBranchReport generateBranchReturnReport(String branchLocation, String branchCity) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        Date curdate = java.sql.Date.valueOf(formatted);

        ReturnBranchReport report = dcch.getBranchReturnReport(curdate, branchLocation, branchCity);

        return report;
    }


}
