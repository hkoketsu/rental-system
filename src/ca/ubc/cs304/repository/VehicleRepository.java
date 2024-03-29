package ca.ubc.cs304.repository;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.database.VehicleListerHelper;
import ca.ubc.cs304.domain.TimeInterval;
import ca.ubc.cs304.domain.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private Connection connection;
    private VehicleListerHelper helper;

    public VehicleRepository(Connection connection) {
        this.connection = connection;
        helper = new VehicleListerHelper();
    }

    public Vehicle getVehicle(String id) {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM VEHICLES WHERE VLICENSE = ?"
            );
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vehicles.add(new Vehicle(
                        rs.getString("vlicense"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getString("year"),
                        rs.getString("color"),
                        rs.getString("odometer"),
                        rs.getString("vtname"),
                        rs.getString("location"),
                        rs.getString("city"),
                        rs.getString("status")
                ));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionHandler.rollbackConnection();
        }
        return vehicles.isEmpty() ? null : vehicles.get(0);
    }

    public Vehicle getRentedVehicle(String vlicense, TimeInterval timeInterval) {
        Vehicle result = null;

        try {
            String query = "SELECT * FROM vehicles v WHERE v.vlicense = '" + vlicense + "'";
            query += helper.getVehiclesHelper(null, null, timeInterval);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            result = new Vehicle(
                    rs.getString("vlicense"),
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

    public List<Vehicle> getVehicles(String carType, String location, TimeInterval timeInterval) {
        List<Vehicle> result = new ArrayList<>();
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> getAvailableVehicleIds(String carType, String location, TimeInterval timeInterval) {
        List<String> ids = new ArrayList<>();
        try {
            String query = "SELECT * FROM vehicles v";
            query += helper.getVehiclesHelper(carType, location, timeInterval);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                ids.add(rs.getString("vlicense"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
}
