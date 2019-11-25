package ca.ubc.cs304.model;

import java.util.ArrayList;
import java.util.List;

public class RentalReport {
    private ArrayList<VehicleModel> vehicleList;
    private ArrayList<String> typeSum;
    private List<String> branchSum;
    private String total;


    public RentalReport(ArrayList<VehicleModel> vehicleList, ArrayList<String> typeSum, ArrayList<String> rest, String total) {
        this.vehicleList = vehicleList;
        this.typeSum = typeSum;
        this.branchSum = rest;
        this.total = total;
    }
    //This is just a list of vehicle models
    public ArrayList<VehicleModel>  getVehicleList() { return vehicleList; }
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
