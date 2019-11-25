package ca.ubc.cs304.repository;

import ca.ubc.cs304.domain.Vehicle;
import ca.ubc.cs304.domain.reports.*;

import java.sql.*;
import java.util.ArrayList;

public class RentalReportRepository {
    private Connection connection;
    private static final String EXCEPTION_TAG = "[EXCEPTION]";

    public RentalReportRepository(Connection connection) {
        this.connection = connection;
    }

    public RentalReport getRentalReport(Date date) {
        String dateString = "to_date('" + date.toString() + "', 'yyyy-mm-dd')";
        return new RentalReport(getVehicleList(dateString, null, null),
                getTypeSum(dateString, null, null), getRentalReportSubBranchSum(dateString),getRentalReportSum(dateString));
    }

    public RentalBranchReport getBranchRentalReport(Date date, String location, String city) {
        String dateString = "to_date('" + date.toString() + "', 'yyyy-mm-dd')";
        return new RentalBranchReport(getVehicleList(dateString, location, city), getTypeSum(dateString, location, city), getRentalReportBranchSum(dateString, location, city));
    }

    private ArrayList<String> getTypeSum(String dateString, String location, String city) {
        ArrayList<String> vtype = new ArrayList();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;
            if(location == null || city == null){
                String query = "SELECT COUNT(*) AS typeSum, v.vtname FROM rentals r INNER JOIN vehicles v ON r.vlicense = v.vlicense WHERE " +
                        "fromDate = "+ dateString +" GROUP BY v.vtname ORDER BY v.vtname";
                rs = stmt.executeQuery(query);
            }
            else {
                String query = "SELECT COUNT(*) AS typeSum, v.vtname FROM rentals r INNER JOIN vehicles v ON r.vlicense = v.vlicense WHERE " +
                        "fromDate = "+ dateString +" AND v.location = "+ location +" AND v.city = "+ city +" GROUP BY v.vtname ORDER BY v.vtname";
                rs = stmt.executeQuery(query);
            }

            while (rs.next()) {
                String model = rs.getString("vtname")+": "+rs.getString("typeSum");
                vtype.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return vtype;
    }

    //Get the branch sub sum of rentals for entire company
    private ArrayList<String> getRentalReportSubBranchSum(String dateString) {
        ArrayList<String> result = new ArrayList();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT COUNT(*) AS vehicles, v.city FROM rentals r INNER JOIN vehicles v ON r.vlicense = v.vlicense WHERE " +
                    "fromDate = "+ dateString +" GROUP BY v.location, v.city ORDER BY v.location");
            while (rs.next()) {
                String model = rs.getString("city")+": "+rs.getString("vehicles");
                result.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result;
    }
    // Get the sum of total rentals in a branch
    private String getRentalReportBranchSum(String dateString, String location, String city) {
        String result ="";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT COUNT(*) AS vehicles, v.city FROM rentals r INNER JOIN vehicles v ON r.vlicense = v.vlicense WHERE " +
                    "fromDate = "+ dateString +" AND v.location = "+ location +" AND v.city = "+ city +" GROUP BY fromDate");
            result = rs.getString("city") + ": " + rs.getString("vehicles");

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result;
    }

    // Get the sum of total rentals in a the company
    private String getRentalReportSum(String dateString) {
        String result ="";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT COUNT(*) AS vehicles FROM rentals r INNER JOIN vehicles v ON r.vlicense = v.vlicense WHERE " +
                    "fromDate = "+ dateString +" GROUP BY fromDate");
            result = "Total: " + rs.getString("vehicles");

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result;
    }


    private ArrayList<Vehicle>  getVehicleList(String dateString, String location, String city) {
        ArrayList<Vehicle> vehicles = new ArrayList();
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs;
            if (location == null || city == null){
                String query = "SELECT " +
                        "v.vlicense, v.make, v.model, v.year, v.color, v.odometer, v.vtname, v.location, v.city, v.status " +
                        "FROM rentals r INNER JOIN vehicles v ON r.vlicense = v.vlicense WHERE " +
                        "fromDate = "+ dateString +"ORDER BY v.location, r.fromTime";
                rs = stmt.executeQuery(query);
            }
            else {
                String query = "SELECT " +
                        "v.vlicense, v.make, v.model, v.year, v.color, v.odometer, v.vtname, v.location, v.city, v.status " +
                        "FROM rentals r INNER JOIN vehicles v ON r.vlicense = v.vlicense WHERE " +
                        "fromDate = "+ dateString +" AND v.location = '"+ location +"' AND v.city = '"+ city + "' ORDER BY v.location, r.fromTime";
                rs = stmt.executeQuery(query);
            }

            while (rs.next()) {
                Vehicle model = new Vehicle(rs.getString("vlicense"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getString("year"),
                        rs.getString("color"),
                        rs.getString("odometer"),
                        rs.getString("vtname"),
                        rs.getString("location"),
                        rs.getString("city"),
                        rs.getString("status"));
                vehicles.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return vehicles;
    }
}

