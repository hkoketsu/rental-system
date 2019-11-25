package ca.ubc.cs304.domain.reports;

import ca.ubc.cs304.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class RentalReport {
    private ArrayList<Vehicle> vehicleList;
    private ArrayList<String> typeSum;
    private List<String> branchSum;
    private String total;


    public RentalReport(ArrayList<Vehicle> vehicleList, ArrayList<String> typeSum, ArrayList<String> rest, String total) {
        this.vehicleList = vehicleList;
        this.typeSum = typeSum;
        this.branchSum = rest;
        this.total = total;
    }
    //This is just a list of vehicle models
    public ArrayList<Vehicle>  getVehicleList() { return vehicleList; }
    /*
    This list of Strings is formatted like "SUV: 3(number of rented SUV)"
    As in the spec, only displaying total number of rentals for specific type for entire company
     */
    public ArrayList<String> getTypeSum() {return typeSum;}
    /*
    This list of Strings is formatted like "Vancouver: 3(number of rented vehicles)"
    As in the spec, displaying total number of rentals for each branch
     */
    public List<String> getBranchSum() {return branchSum;}
    //This String is formatted like "total: 3(total number of rented vehicles for entire company)"
    public String getTotal() {return total;}


}
