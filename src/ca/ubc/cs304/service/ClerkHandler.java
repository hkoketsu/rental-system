package ca.ubc.cs304.service;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Return;
import ca.ubc.cs304.domain.receipt.RentalReceipt;
import ca.ubc.cs304.domain.reports.RentalBranchReport;
import ca.ubc.cs304.domain.reports.ReturnBranchReport;
import ca.ubc.cs304.domain.reports.ReturnReport;
import ca.ubc.cs304.domain.reports.RentalReport;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        Date curdate = java.sql.Date.valueOf(formatted);

        RentalReport report = cdh.getRentalReport(curdate);

        return report;
    }

    public RentalBranchReport generateBranchRentalReport(String branchLocation, String branchCity) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        Date curdate = java.sql.Date.valueOf(formatted);

        RentalBranchReport report = cdh.getRentalBranchReport(curdate, branchLocation, branchCity);

        return report;
    }

    public ReturnReport generateReturnReport() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        Date curdate = java.sql.Date.valueOf(formatted);

        ReturnReport report = cdh.getReturnReport(curdate);

        return report;
    }

    public ReturnBranchReport generateBranchReturnReport(String branchLocation, String branchCity) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        Date curdate = java.sql.Date.valueOf(formatted);

        ReturnBranchReport report = cdh.getReturnBranchReport(curdate, branchLocation, branchCity);

        return report;
    }


}
