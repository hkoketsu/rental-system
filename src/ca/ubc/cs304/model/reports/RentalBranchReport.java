package ca.ubc.cs304.model.reports;

import ca.ubc.cs304.model.VehicleModel;

import java.util.ArrayList;
import java.util.List;

public class RentalBranchReport {
    private ArrayList<VehicleModel> vehicleList;
    private ArrayList<String> typeSum;
    private String total;


    public RentalBranchReport(ArrayList<VehicleModel> vehicleList, ArrayList<String> typeSum, String total) {
        this.vehicleList = vehicleList;
        this.typeSum = typeSum;
        this.total = total;
    }
    //This is just a list of vehicle models
    public ArrayList<VehicleModel>  getVehicleList() {
        return vehicleList;
    }
    /*/
    This list of Strings is formatted like "SUV: 3(number of rented SUV)"
    As in the spec, only displaying total number of rentals for specific type for the specified branch
     */
    public ArrayList<String> getTypeSum() {return typeSum;}
    //This String is formatted like "total: 3(total number of rented vehicles)"
    public String getTotal() {return total;}


}
