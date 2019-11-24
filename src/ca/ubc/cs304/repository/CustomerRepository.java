package ca.ubc.cs304.repository;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {
    private Connection connection;

    public CustomerRepository(Connection connection) {
        this.connection = connection;
    }

    public void insertCustomer(Customer model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO customers VALUES (?,?,?,?)");
            ps.setString(1, model.getDlicense());
            ps.setString(2, model.getCellphone());
            ps.setString(3, model.getName());
            ps.setString(4, model.getAddress());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionHandler.rollbackConnection();
        }
    }




    public Customer[] getCustomerInfo(String dlicense) {
        ArrayList<Customer> result = new ArrayList<Customer>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers c WHERE c.dlicense = '" + dlicense + "'");

            while (rs.next()) {
                Customer model = new Customer(rs.getString("dlicense"),
                        rs.getString("cellphone"),
                        rs.getString("name"),
                        rs.getString("address"));
                result.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result.toArray(new Customer[result.size()]);
    }


}
