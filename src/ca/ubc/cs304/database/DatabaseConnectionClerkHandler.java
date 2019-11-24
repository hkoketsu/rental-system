package ca.ubc.cs304.database;

import ca.ubc.cs304.model.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class handles all database related transactions
 */
public class DatabaseConnectionClerkHandler {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public DatabaseConnectionClerkHandler() {
        try {
            // Load the Oracle JDBC driver
            // Note that the path could change for new drivers
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public RentalReport getReport(Date date) {
        String dateString = "to_date('" + date.toString() + "', 'yyyy-mm-dd')";
        return new RentalReport(getVehicleList(dateString, null, null),
                getTypeSum(dateString, null, null), getReportSum(dateString, null, null));
    }

    public RentalReport getBranchReport(Date date, String location, String city) {
        String dateString = "to_date('" + date.toString() + "', 'yyyy-mm-dd')";
        return new RentalReport(getVehicleList(dateString, location, city), getTypeSum(dateString, location, city), getReportSum(dateString, location, city));
    }

    private ArrayList<String> getTypeSum(String dateString, String location, String city) {
        ArrayList<String> vtype = new ArrayList();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;
            if(location == null || city == null){
                rs = stmt.executeQuery("SELECT COUNT(v.vlicense), v.vtname FROM rentals r INNER JOIN vehicles v WHERE " +
                        "fromDate = "+ dateString +" GROUP BY v.vtname ORDER BY v.vtname");
            }
            else {
                rs = stmt.executeQuery("SELECT COUNT(v.vlicense), v.vtname FROM rentals r INNER JOIN vehicles v WHERE " +
                        "fromDate = "+ dateString +" AND v.location = "+ location +" AND v.city = "+ city +" GROUP BY v.vtname ORDER BY v.vtname");
            }

            while (rs.next()) {
                String model = rs.getString("vtname")+": "+rs.getString("vlicense");
                vtype.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return vtype;
    }

    private ArrayList<String> getReportSum(String dateString, String location, String city) {
        ArrayList<String> result = new ArrayList();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;
            if(location == null || city == null) {
                rs = stmt.executeQuery("SELECT COUNT(v.vlicense), v.city FROM rentals r INNER JOIN vehicles v WHERE " +
                        "fromDate = "+ dateString +" GROUP BY v.location, v.city ORDER BY v.location");
                Integer total = 0;
                while (rs.next()) {
                    String model = rs.getString("city")+": "+rs.getString("vlicense");
                    total += rs.getInt("vlicense");
                    result.add(model);
                }
                result.add("total: " + total.toString());
            }
            else {
                rs = stmt.executeQuery("SELECT COUNT(v.vlicense), v.city FROM rentals r INNER JOIN vehicles v WHERE " +
                        "fromDate = "+ dateString +" AND v.location = "+ location +" AND v.city = "+ city);
                result.add("total: " + rs.getString("vlicense"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result;
    }


    private ArrayList<VehicleModel>  getVehicleList(String dateString, String location, String city) {
        ArrayList<VehicleModel> vehicles = new ArrayList();
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs;
            if (location == null || city == null){
                rs = stmt.executeQuery("SELECT " +
                        "v.vlicense, v.make, v.model, v.year, v.color, v.odometer, v.vtname, v.location, v.city FROM rentals r INNER JOIN vehicles v WHERE " +
                        "fromDate = "+ dateString +" GROUP BY location, vtname ORDER BY v.location, r.fromTime");
            }
            else {
                rs = stmt.executeQuery("SELECT " +
                        "v.vlicense, v.make, v.model, v.year, v.color, v.odometer, v.vtname, v.location, v.city FROM rentals r INNER JOIN vehicles v WHERE " +
                        "fromDate = "+ dateString +" AND v.location = "+ location +" AND v.city = "+ city +
                        " GROUP BY location, vtname ORDER BY v.location, r.fromTime");
            }

            while (rs.next()) {
                VehicleModel model = new VehicleModel(rs.getString("vlicense"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getString("year"),
                        rs.getString("color"),
                        rs.getString("odometer"),
                        rs.getString("vtname"),
                        rs.getString("location"),
                        rs.getString("city"),
                        null);
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

//            while (rs.next()) {
//                RentalsModel model = new RentalsModel(rs.getString("rid"),
//                        rs.getString("vlicense"),
//                        rs.getString("dlicense"),
//                        rs.getDate("fromDate"),
//                        rs.getString("fromTime"),
//                        rs.getDate("toDate"),
//                        rs.getString("toTime"),
//                        rs.getInt("odometer"),
//                        rs.getString("cardName"),
//                        rs.getString("cardNo"),
//                        rs.getString("expDate"),
//                        rs.getString("confNo"));
//                result.add(model);
//            }