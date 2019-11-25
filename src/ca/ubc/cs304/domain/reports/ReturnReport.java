package ca.ubc.cs304.domain.reports;

import ca.ubc.cs304.domain.Vehicle;

import java.util.ArrayList;

public class ReturnReport {

    private ArrayList<Vehicle> vehicleList;
    private ArrayList<ReturnReportBranchSummary> breports;
    private ArrayList<String> branchSum;
    private String total;


    public ReturnReport(ArrayList<Vehicle> vehicleList, ArrayList<ReturnReportBranchSummary> breports, ArrayList<String> rest, String total) {
        this.vehicleList = vehicleList;
        this.breports = breports;
        this.branchSum = rest;
        this.total = total;
    }
    //This is just a list of vehicle models
    public ArrayList<Vehicle>  getVehicleList() { return vehicleList; }
    //This is a list of ReturnReportBranchSummary, please check the spec for that
    public ArrayList<ReturnReportBranchSummary> getBreports() {return breports;}
    /*
    This list of Strings is formatted like:
    "Vancouver returns: 3(number of returned vehicles) revenue: 800(revenue for the branch)"
    As in the spec, displaying total number of returns and the revenue for a branch
     */
    public ArrayList<String> getBranchSum() {return branchSum;}
    /*
    This String is formatted like:
    "total return: 3 (total number of returned vehicles for entire company) revenue: 1000 (total revenue for entire company)"
     */
    public String getTotal() {return total;}
}
