package ca.ubc.cs304.model;

import java.util.ArrayList;
import java.util.List;

public class ReturnReport {

    private ArrayList<VehicleModel> vehicleList;
    private ArrayList<String> typeSum;
    private List<String> branchSum;
    private String total;


    public ReturnReport(ArrayList<VehicleModel> vehicleList, ArrayList<String> typeSum, ArrayList<String> rest) {
        this.vehicleList = vehicleList;
        this.typeSum = typeSum;
        if(rest.size() > 1) {
            this.branchSum = rest.subList(0,rest.size()-1);
            this.total = rest.get(rest.size()-1);
        }
        else this.total = rest.get(0);
    }

    public ArrayList<VehicleModel>  getVehicleList() {
        return vehicleList;
    }

    public ArrayList<String> getTypeSum() {return typeSum;}

    public List<String> getBranchSum() {return branchSum;}

    public String getTotal() {return total;}
}
