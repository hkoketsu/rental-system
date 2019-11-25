package ca.ubc.cs304.repository;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.InsuranceRate;
import ca.ubc.cs304.domain.VehicleRate;
import ca.ubc.cs304.domain.VehicleType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleTypeRepository {
    private Connection connection;

    public VehicleTypeRepository(Connection connection) {
        this.connection = connection;
    }

    public VehicleType getVehicleTypeObj(String id) {
        List<VehicleType> vehicleTypes = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM VEHICLETYPES WHERE VTNAME = ?"
            );
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                VehicleRate vehicleRate = new VehicleRate(
                        rs.getInt("wrate"),
                        rs.getInt("drate"),
                        rs.getInt("hrate")
                );
                InsuranceRate insuranceRate = new InsuranceRate(
                        rs.getInt("wirate"),
                        rs.getInt("dirate"),
                        rs.getInt("hirate")
                );
                vehicleTypes.add(new VehicleType(
                        rs.getString("vtname"),
                        rs.getString("features"),
                        vehicleRate,
                        insuranceRate,
                        rs.getInt("krate")
                ));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionHandler.rollbackConnection();
        }
        return vehicleTypes.isEmpty() ? null : vehicleTypes.get(0);
    }
}
