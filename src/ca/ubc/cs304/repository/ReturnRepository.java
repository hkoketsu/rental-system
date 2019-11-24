package ca.ubc.cs304.repository;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Return;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReturnRepository {
    private Connection connection;

    public ReturnRepository(Connection connection) {
        this.connection = connection;
    }

    public void returnVehicle(Return returnObj) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO RETURNS VALUES (?, ?, ?, ?, ?, ?);"
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
