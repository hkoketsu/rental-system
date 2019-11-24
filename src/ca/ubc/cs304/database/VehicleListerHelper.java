package ca.ubc.cs304.database;


import ca.ubc.cs304.domain.TimeInterval;

public class VehicleListerHelper {

    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    public String getVehiclesHelper(String carType, String location, TimeInterval timeInterval) {
        String query = "";
        String leftCase = null;
        String rightCase = null;
        String centerCase = null;
        if (timeInterval != null) {
            leftCase = "r.fromDate <= " + timeInterval.getFromDateFormatted() +
                    " AND r.toDate >= " + timeInterval.getToDateFormatted();
            rightCase = "r.fromDate <= " + timeInterval.getFromDateFormatted() +
                    " AND r.toDate >= " + timeInterval.getToDateFormatted();
            centerCase = "r.fromDate >= " + timeInterval.getFromDateFormatted() +
                    " AND r.toDate <= " + timeInterval.getToDateFormatted();
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

}
