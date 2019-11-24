package ca.ubc.cs304.repository;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Reservation;
import ca.ubc.cs304.domain.TimeInterval;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private Connection connection;

    public ReservationRepository(Connection connection) {
        this.connection = connection;
    }

    public Reservation getReservation(String confirmationNumber) {
        List<Reservation> reservationList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM RESERVATIONS WHERE confNo = ?");
            ps.setString(1, confirmationNumber);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TimeInterval duration = new TimeInterval(
                        rs.getDate("fromDate"),
                        rs.getDate("toDate"),
                        rs.getString("fromTime"),
                        rs.getString("toTime")
                );
                reservationList.add(new Reservation(
                        rs.getString("confNo"),
                        rs.getString("vtname"),
                        rs.getString("dlicense"),
                        null,
                        duration
                ));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionHandler.rollbackConnection();
        }
        return reservationList.get(0);
    }

    public String[] getReservationConfnoInfo() {
        ArrayList<String> result = new ArrayList<String>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT r.confNo FROM reservations r");

            while (rs.next()) {
                String temp = rs.getString("confNo");
                result.add(temp);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result.toArray(new String[result.size()]);
    }

    public void insertReservation(Reservation reservation) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO reservations VALUES (?,?,?,?,?,?,?)");
            TimeInterval duration = reservation.getDuration();

            ps.setString(1, reservation.getId());
            ps.setString(2, reservation.getVehicleType());
            ps.setString(3, reservation.getCustomerId());
            ps.setDate(4, duration.getFromDate());
            ps.setString(5, duration.getFromTime());
            ps.setDate(6, duration.getToDate());
            ps.setString(7, duration.getToTime());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionHandler.rollbackConnection();
        }
    }
}
