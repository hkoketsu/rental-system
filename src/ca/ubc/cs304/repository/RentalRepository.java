package ca.ubc.cs304.repository;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.CreditCard;
import ca.ubc.cs304.domain.Rental;
import ca.ubc.cs304.domain.TimeInterval;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalRepository {
    private Connection connection;

    public RentalRepository(Connection connection) {
        this.connection = connection;
    }

    public Rental getRentalInfo(String id) {
        List<Rental> rentals = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM RENTALS WHERE CONFNO = ?"
            );
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TimeInterval duration = new TimeInterval(
                        rs.getDate("fromDate"),
                        rs.getDate("toDate"),
                        rs.getString("fromTime"),
                        rs.getString("toTime")
                );
                CreditCard creditCard = new CreditCard(
                        rs.getString("cardName"),
                        rs.getString("cardNo"),
                        rs.getString("expDate")
                );
                rentals.add(new Rental(
                        rs.getString("rid"),
                        rs.getString("vlicense"),
                        rs.getString("dlicense"),
                        duration,
                        rs.getInt("odometer"),
                        creditCard,
                        rs.getString("confNo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals.get(0);
    }

    public void rentVehicle(Rental rental) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO rentals VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
            );
            CreditCard card = rental.getCreditCard();
            TimeInterval duration = rental.getDuration();
            ps.setString(1, rental.getId());
            ps.setString(2, rental.getVehicleId());
            ps.setString(3, rental.getCustomerId());
            ps.setDate(4, duration.getFromDate());
            ps.setString(5, duration.getFromTime());
            ps.setDate(6, duration.getToDate());
            ps.setString(7, duration.getToTime());
            ps.setInt(8, rental.getOdometer());
            ps.setString(9, card.getName());
            ps.setString(10, card.getNumber());
            ps.setString(11, card.getExpDate());
            if (rental.getConfirmationNumber() != null) {
                ps.setString(12, rental.getConfirmationNumber());
            } else {
                ps.setNull(12, Types.VARCHAR);
            }

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionHandler.rollbackConnection();
        }
    }
}
