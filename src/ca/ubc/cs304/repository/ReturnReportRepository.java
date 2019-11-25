package ca.ubc.cs304.repository;

import ca.ubc.cs304.domain.Vehicle;
import ca.ubc.cs304.domain.reports.ReturnBranchReport;
import ca.ubc.cs304.domain.reports.ReturnReport;
import ca.ubc.cs304.domain.reports.ReturnReportBranchSummary;

import java.sql.*;
import java.util.ArrayList;

public class ReturnReportRepository {
    private Connection connection;
    private static final String EXCEPTION_TAG = "[EXCEPTION]";

    public ReturnReportRepository(Connection connection) {
        this.connection = connection;
    }

    public ReturnReport getReturnReport(Date date) {
        String dateString = "to_date('" + date.toString() + "', 'yyyy-mm-dd')";
        return new ReturnReport(getReturnVehicleList(dateString, null, null),
                getBranchReturnReport(dateString, null, null),
                getReturnReportSubBranchSum(dateString), getReturnReportSum(dateString));
    }

    public ReturnBranchReport getBranchReturnReport(Date date, String location, String city) {
        String dateString = "to_date('" + date.toString() + "', 'yyyy-mm-dd')";
        return new ReturnBranchReport(getReturnVehicleList(dateString, location, city), getBranchReturnReport(dateString, location, city), getReturnReportBranchSum(dateString, location, city));
    }

    private ArrayList<ReturnReportBranchSummary> getBranchReturnReport(String dateString, String location, String city) {
        ArrayList<ReturnReportBranchSummary> branches = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;
            if(location == null || city == null){
                rs = stmt.executeQuery("SELECT COUNT(*) AS vehicles, v.vtname, SUM(r.value) AS revenue, v.city FROM" +
                        " ((rentals re INNER JOIN vehicles v ON re.vlicense = v.vlicense) INNER JOIN returns r ON r.rid = re.rid) WHERE " +
                        "r.rdate = "+ dateString +" GROUP BY v.vtname, v.location, v.city ORDER BY v.location, v.vtname");
            }
            else {
                rs = stmt.executeQuery("SELECT COUNT(*) AS vehicles, v.vtname, SUM(r.value) AS revenue, v.city FROM" +
                        " ((rentals re INNER JOIN vehicles v ON re.vlicense = v.vlicense) INNER JOIN returns r ON r.rid = re.rid) WHERE " +
                        "r.rdate = "+ dateString +" AND v.location = "+ location +" AND v.city = "+ city +" GROUP BY v.vtname ORDER BY v.vtname");
            }

            while (rs.next()) {
                ReturnReportBranchSummary model = new ReturnReportBranchSummary(rs.getString("city"),
                        rs.getString("vehicles"),
                        rs.getString("vtname"),
                        rs.getDouble("value")
                );
                branches.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return branches;
    }

    private ArrayList<Vehicle>  getReturnVehicleList(String dateString, String location, String city) {
        ArrayList<Vehicle> vehicles = new ArrayList();
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs;
            if (location == null || city == null){
                String query = "SELECT " +
                        "v.vlicense, v.make, v.model, v.year, v.color, v.odometer, v.vtname, v.location, v.city, v.status " +
                        "FROM ((rentals re INNER JOIN vehicles v ON re.vlicense = v.vlicense) INNER JOIN returns r ON r.rid = re.rid) WHERE " +
                        "r.rdate = "+ dateString +"ORDER BY v.location, r.rtime";
                rs = stmt.executeQuery(query);
            }
            else {
                rs = stmt.executeQuery("SELECT " +
                        "v.vlicense, v.make, v.model, v.year, v.color, v.odometer, v.vtname, v.location, v.city, v.status " +
                        "FROM ((rentals re INNER JOIN vehicles v ON re.vlicense = v.vlicense) INNER JOIN returns r ON r.rid = re.rid) WHERE " +
                        "r.rdate = "+ dateString +" AND v.location = "+ location +" AND v.city = "+ city + " ORDER BY v.location, r.rtime");
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

    //Get the branch sub sum of rentals for entire company
    private ArrayList<String> getReturnReportSubBranchSum(String dateString) {
        ArrayList<String> result = new ArrayList();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT COUNT(*) AS vehicles, v.city , SUM(r.value) AS revenue " +
                    "FROM ((rentals re INNER JOIN vehicles v ON re.vlicense = v.vlicense) INNER JOIN returns r ON r.rid = re.rid)  WHERE " +
                    "r.rdate = "+ dateString +" GROUP BY v.location, v.city ORDER BY v.location");
            while (rs.next()) {
                String model = rs.getString("city")+" returns: "+rs.getString("vehicles") + " revenue: "+ rs.getString("revenue");
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
    private String getReturnReportBranchSum(String dateString, String location, String city) {
        String result ="";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT COUNT(*) AS vehicles, v.city , SUM(r.value) AS revenue " +
                    " FROM ((rentals re INNER JOIN vehicles v ON re.vlicense = v.vlicense) INNER JOIN returns r ON r.rid = re.rid)  WHERE " +
                    "r.rdate = "+ dateString +" AND v.location = "+ location +" AND v.city = "+ city);
            result = rs.getString("city")+ " returns: "+rs.getString("vehicles") + " revenue: "+ rs.getString("revenue");

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result;
    }

    // Get the sum of total rentals in a the company
    private String getReturnReportSum(String dateString) {
        String result ="";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT COUNT(*) AS vehicles, SUM(r.value) AS revenue " +
                    "FROM ((rentals re INNER JOIN vehicles v ON re.vlicense = v.vlicense) INNER JOIN returns r ON r.rid = re.rid) WHERE " +
                    "r.rdate = "+ dateString +" GROUP BY r.rdate");
            result = "Total "+ " returns: "+rs.getString("vehicles") + " revenue: "+ rs.getString("revenue");

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result;
    }
}
