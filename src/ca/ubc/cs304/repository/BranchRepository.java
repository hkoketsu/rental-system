package ca.ubc.cs304.repository;

import ca.ubc.cs304.domain.Branch;
import ca.ubc.cs304.domain.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BranchRepository {
    private Connection connection;

    public BranchRepository(Connection connection) {
        this.connection = connection;
    }

    public List<String> getCityInfo() {
        List<String> cities = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT CITY FROM BRANCH c");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cities.add(rs.getString("city"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public List<String> getBranchLocations(String city) {
        List<String> branchLocations = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM BRANCH c WHERE CITY = ?");
            ps.setString(1, city);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                branchLocations.add(rs.getString("location"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branchLocations;
    }

    public List<String> getBranchLocations() {
        List<String> branchLocations = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT BRANCH.LOCATION FROM BRANCH");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                branchLocations.add(rs.getString("location"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branchLocations;
    }
}
