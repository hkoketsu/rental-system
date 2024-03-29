package ca.ubc.cs304.domain.reports;

import ca.ubc.cs304.domain.Vehicle;

import java.util.ArrayList;

public class ReturnBranchReport {
    private ArrayList<Vehicle> vehicleList;
    private ArrayList<ReturnReportBranchSummary> breports;
    private String total;


    public ReturnBranchReport(ArrayList<Vehicle> vehicleList, ArrayList<ReturnReportBranchSummary> breports, String total) {
        this.vehicleList = vehicleList;
        this.breports = breports;
        this.total = total;
    }
    //This is just a list of vehicle models
    public ArrayList<Vehicle>  getVehicleList() {
        return vehicleList;
    }
    //This is a list of ReturnReportBranchSummary, please check the spec for that
    public ArrayList<ReturnReportBranchSummary> getBreports() {return breports;}
    /*
    This String is formatted like:
    "total return: 3 (total number of returned vehicles for specific branch) revenue: 1000 (total revenue for specific branch)"
     */
    public String getTotal() {return total;}


}
