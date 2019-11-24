package ca.ubc.cs304.repository;

import ca.ubc.cs304.database.VehicleListerHelper;
import ca.ubc.cs304.domain.TimeInterval;
import ca.ubc.cs304.domain.Vehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VehicleRepository {
    private Connection connection;
    private VehicleListerHelper helper;

    public VehicleRepository(Connection connection) {
        this.connection = connection;
        helper = new VehicleListerHelper();
    }

    public Vehicle getRentedVehicle(String vlicense, TimeInterval timeInterval) {
        Vehicle result = null;

        try {
            String query = "SELECT * FROM vehicles v WHERE v.vlicense = '" + vlicense + "'";
            query += helper.getVehiclesHelper(null, null, timeInterval);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            Vehicle model = new Vehicle(rs.getString("vlicense"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getString("year"),
                    rs.getString("color"),
                    rs.getString("odometer"),
                    rs.getString("vtname"),
                    rs.getString("location"),
                    rs.getString("city"),
                    rs.getString("status")
            );
            result = model;

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int numberOfVehiclesNotRented(String carType, String location, TimeInterval timeInterval) {
        try {
            int result;
            String query = "SELECT count(*) FROM vehicles v";
            query += helper.getVehiclesHelper(carType, location, timeInterval);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            result = rs.getInt(1);

            rs.close();
            stmt.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /*
            This query is of the form:

            select *
            from reservations r
            where
                r.vtname = <carType> AND
                r.fromDate >= <fromDate> AND
                r.toDate <= <toDate>
         */
    public int numberOfReservedVehicles(String carType, TimeInterval timeInterval) {
        try {
            int result;
            String query = "SELECT count(*) FROM reservations r";
            if (carType != null && timeInterval != null) {
                query += " WHERE r.vtname = " + "'" + carType + "'";
                query += " AND r.fromDate >= " + timeInterval.getFromDateFormatted();
                query += " AND r.toDate <= " + timeInterval.getToDateFormatted();
            } else if (carType != null) {
                query += " WHERE r.vtname = " + "'" +carType + "'";
            } else if (timeInterval != null) {
                query += " WHERE r.fromDate >= " + timeInterval.getFromDateFormatted();
                query += " AND r.toDate <= " + timeInterval.getToDateFormatted();
            }

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            result = rs.getInt(1);

            rs.close();
            stmt.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Vehicle[] getVehicles(String carType, String location, TimeInterval timeInterval) {
        try {
            ArrayList<Vehicle> result = new ArrayList<Vehicle>();
            String query = "SELECT * FROM vehicles v";
            query += helper.getVehiclesHelper(carType, location, timeInterval);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                Vehicle model = new Vehicle(
                        rs.getNString("vlicense"),
                        rs.getNString("make"),
                        rs.getNString("model"),
                        rs.getNString("year"),
                        rs.getNString("color"),
                        rs.getNString("odometer"),
                        rs.getNString("vtname"),
                        rs.getNString("location"),
                        rs.getNString("city"),
                        rs.getNString("status")
                );
                result.add(model);
            }
            rs.close();
            stmt.close();

            return result.toArray(new Vehicle[result.size()]);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
