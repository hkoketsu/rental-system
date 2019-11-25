package ca.ubc.cs304.repository;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Rental;
import ca.ubc.cs304.domain.Return;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReturnRepository {
    private Connection connection;

    public ReturnRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean checkReturnEntry(String id) {
        List<String> returnIds = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM RETURNS WHERE rid = ?"
            );
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                returnIds.add(rs.getString("rid"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionHandler.rollbackConnection();
        }
        return !returnIds.isEmpty();
    }

    public void returnVehicle(Return returnObj) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO RETURNS (rid, rdate, rtime, odometer, fulltank, value) " +
                            "VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, returnObj.getId());
            ps.setDate(2, returnObj.getDate());
            ps.setString(3, returnObj.getTime());
            ps.setInt(4, returnObj.getOdometer());
            ps.setBoolean(5, returnObj.isFullTank());
            ps.setInt(6, returnObj.getValue());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionHandler.rollbackConnection();
        }
    }
}
