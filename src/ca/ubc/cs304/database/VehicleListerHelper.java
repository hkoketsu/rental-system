package ca.ubc.cs304.database;

import ca.ubc.cs304.model.TimeInterval;
import ca.ubc.cs304.model.VehicleModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VehicleListerHelper {

    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public VehicleListerHelper(Connection connection) {
        this.connection = connection;
    }

    private String getVehiclesHelper(String carType, String location, TimeInterval timeInterval) {
        String query = "";
        String leftCase = null;
        String rightCase = null;
        String centerCase = null;
        if (timeInterval != null) {
            leftCase = "r.fromDate <= " + timeInterval.getFromDateFormated() +
                    " AND r.toDate >= " + timeInterval.getFromDateFormated();
            rightCase = "r.fromDate <= " + timeInterval.getToDateFormated() +
                    " AND r.toDate >= " + timeInterval.getToDateFormated();
            centerCase = "r.fromDate >= " + timeInterval.getFromDateFormated() +
                    " AND r.toDate <= " + timeInterval.getToDateFormated();
        }
        if (carType != null && location != null && timeInterval != null) {
            query += " WHERE  v.vtname = " + "'" + carType + "'";
            query += " AND v.location = " + "'" + location + "'";
            query += " AND v.vlicense NOT IN ( " +
                    "SELECT r.vlicense " +
                    "FROM rentals r " +
                    "WHERE ( " + leftCase + " ) OR ( " + rightCase + " ) OR ( " + centerCase + " ) )";
        } else if (carType != null && location != null ) {
            query += " WHERE  v.vtname = " + "'" +carType + "'";
            query += " AND v.location = " + "'" +location + "'";
        } else if (location != null && timeInterval != null) {
            query += " WHERE v.location = " + "'" +location + "'";
            query += " AND v.vlicense NOT IN ( " +
                    "SELECT r.vlicense " +
                    "FROM rentals r " +
                    "WHERE ( " + leftCase + " ) OR ( " + rightCase + " ) OR ( " + centerCase + " ) )";
        } else if (carType != null && timeInterval != null) {
            query += " WHERE  v.vtname = " + "'" +carType + "'";
            query += " AND v.vlicense NOT IN ( " +
                    "SELECT r.vlicense " +
                    "FROM rentals r " +
                    "WHERE ( " + leftCase + " ) OR ( " + rightCase + " ) OR ( " + centerCase + " ) )";
        } else if (carType != null ) {
            query += " WHERE  v.vtname = " + "'" + carType + "'";
        } else if (location != null ) {
            query += " WHERE v.location = " + "'" + location + "'";
        } else if (timeInterval != null) {
            query += " WHERE v.vlicense NOT IN ( " +
                    "SELECT r.vlicense " +
                    "FROM rentals r " +
                    "WHERE ( " + leftCase + " ) OR ( " + rightCase + " ) OR ( " + centerCase + " ) )";
        }
        return query;
    }

    /*
        This query is of the form:

        select *
        from vehicles v
        where
            v.vtname = <carType> AND
            v.location = <location> AND
            v.vlicense not in (
                select r.vlicense
                from rentals r
                where
                ( r.fromDate <= <fromDate> AND
                r.toDate >= <fromDate> ) OR
                ( r.fromDate <= <toDate> AND
                r.toDate >= <toDate ) OR
                ( r.fromDate >= <fromDate> AND
                r.toDate <= <toDate> )
            )
     */
    public VehicleModel[] getVehicles(String carType, String location, TimeInterval timeInterval) {
        try {
            ArrayList<VehicleModel> result = new ArrayList<VehicleModel>();
            String query = "SELECT * FROM vehicles v";
            query += this.getVehiclesHelper(carType, location, timeInterval);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                VehicleModel model = new VehicleModel(
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

            return result.toArray(new VehicleModel[result.size()]);

        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            return null;
        }
    }

    /*
        This query is of the form:

        select count(*)
        from vehicles v
        where
            v.vtname = <carType> AND
            v.location = <location> AND
            v.vlicense not in (
                select r.vlicense
                from rentals r
                where
                ( r.fromDate <= <fromDate> AND
                r.toDate >= <fromDate> ) OR
                ( r.fromDate <= <toDate> AND
                r.toDate >= <toDate ) OR
                ( r.fromDate >= <fromDate> AND
                r.toDate <= <toDate> )
            )
     */
    public int numberOfVehiclesNotRented(String carType, String location, TimeInterval timeInterval) {
        try {
            int result;
            String query = "SELECT count(*) FROM vehicles v";
            query += this.getVehiclesHelper(carType, location, timeInterval);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            result = rs.getInt(1);

            rs.close();
            stmt.close();
            return result;
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
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
                query += " AND r.fromDate >= " + timeInterval.getFromDateFormated();
                query += " AND r.toDate <= " + timeInterval.getToDateFormated();
            } else if (carType != null) {
                query += " WHERE r.vtname = " + "'" +carType + "'";
            } else if (timeInterval != null) {
                query += " WHERE r.fromDate >= " + timeInterval.getFromDateFormated();
                query += " AND r.toDate <= " + timeInterval.getToDateFormated();
            }

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            result = rs.getInt(1);

            rs.close();
            stmt.close();
            return result;
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            return -1;
        }
    }

    /*
        This query is of the form:

        select *
        from vehicles v
        where
            v.vlicense = <vlicense> AND
            v.vlicense not in (
                select r.vlicense
                from rentals r
                where
                ( r.fromDate <= <fromDate> AND
                r.toDate >= <fromDate> ) OR
                ( r.fromDate <= <toDate> AND
                r.toDate >= <toDate ) OR
                ( r.fromDate >= <fromDate> AND
                r.toDate <= <toDate> )
            )
     */
    // returns the vehicle with the given vlicense if it is not rented within the time interval
    public VehicleModel getRentedVehicle(String vlicense, TimeInterval timeInterval) {
        VehicleModel result = null;

        try {
            String query = "SELECT * FROM vehicles v WHERE v.vlicense = '" + vlicense + "'";
            query += getVehiclesHelper(null, null, timeInterval);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            VehicleModel model = new VehicleModel(rs.getString("vlicense"),
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
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result;

    }
}
