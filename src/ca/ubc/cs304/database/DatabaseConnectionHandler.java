package ca.ubc.cs304.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ca.ubc.cs304.model.BranchModel;
import ca.ubc.cs304.model.CustomerModel;
import ca.ubc.cs304.model.TimeInterval;
import ca.ubc.cs304.model.VehicleModel;

/**
 * This class handles all database related transactions
 */
public class DatabaseConnectionHandler {
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
	private static final String EXCEPTION_TAG = "[EXCEPTION]";
	private static final String WARNING_TAG = "[WARNING]";
	
	private Connection connection = null;
	
	public DatabaseConnectionHandler() {
		try {
			// Load the Oracle JDBC driver
			// Note that the path could change for new drivers
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}
	
	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void deleteBranch(int branchId) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM branch WHERE branch_id = ?");
			ps.setInt(1, branchId);
			
			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Branch " + branchId + " does not exist!");
			}
			
			connection.commit();
	
			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertBranch(BranchModel model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO branch VALUES (?,?,?,?,?)");
			ps.setInt(1, model.getId());
			ps.setString(2, model.getName());
			ps.setString(3, model.getAddress());
			ps.setString(4, model.getCity());
			if (model.getPhoneNumber() == 0) {
				ps.setNull(5, java.sql.Types.INTEGER);
			} else {
				ps.setInt(5, model.getPhoneNumber());
			}

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertCustomer(CustomerModel model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?)");
			ps.setString(1, model.getDlicense());
			ps.setString(2, model.getCellphone());
			ps.setString(3, model.getName());
			ps.setString(4, model.getAddress());
//			if (model.getPhoneNumber() == 0) {
//				ps.setNull(5, java.sql.Types.INTEGER);
//			} else {
//				ps.setInt(5, model.getPhoneNumber());
//			}

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}
	
	public BranchModel[] getBranchInfo() {
		ArrayList<BranchModel> result = new ArrayList<BranchModel>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM branch");
		
//    		// get info on ResultSet
//    		ResultSetMetaData rsmd = rs.getMetaData();
//
//    		System.out.println(" ");
//
//    		// display column names;
//    		for (int i = 0; i < rsmd.getColumnCount(); i++) {
//    			// get column name and print it
//    			System.out.printf("%-15s", rsmd.getColumnName(i + 1));
//    		}
			
			while(rs.next()) {
				BranchModel model = new BranchModel(rs.getString("branch_addr"),
													rs.getString("branch_city"),
													rs.getInt("branch_id"),
													rs.getString("branch_name"),
													rs.getInt("branch_phone"));
				result.add(model);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return result.toArray(new BranchModel[result.size()]);
	}
	public CustomerModel[] getCustomerInfo() {
		ArrayList<CustomerModel> result = new ArrayList<CustomerModel>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

//    		// get info on ResultSet
//    		ResultSetMetaData rsmd = rs.getMetaData();
//
//    		System.out.println(" ");
//
//    		// display column names;
//    		for (int i = 0; i < rsmd.getColumnCount(); i++) {
//    			// get column name and print it
//    			System.out.printf("%-15s", rsmd.getColumnName(i + 1));
//    		}

			while(rs.next()) {
                CustomerModel model = new CustomerModel(rs.getString("dlicense"),
													rs.getString("cellphone"),
													rs.getString("name"),
													rs.getString("address"));
				result.add(model);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}

		return result.toArray(new CustomerModel[result.size()]);
	}
	
	public void updateBranch(int id, String name) {
		try {
		  PreparedStatement ps = connection.prepareStatement("UPDATE branch SET branch_name = ? WHERE branch_id = ?");
		  ps.setString(1, name);
		  ps.setInt(2, id);
		
		  int rowCount = ps.executeUpdate();
		  if (rowCount == 0) {
		      System.out.println(WARNING_TAG + " Branch " + id + " does not exist!");
		  }
	
		  connection.commit();
		  
		  ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}	
	}
	
	public boolean login(String username, String password) {
		try {
			if (connection != null) {
				connection.close();
			}
	
			connection = DriverManager.getConnection(ORACLE_URL, username, password);
			connection.setAutoCommit(false);
	
			System.out.println("\nConnected to Oracle!");
			return true;
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			return false;
		}
	}

	private void rollbackConnection() {
		try  {
			connection.rollback();	
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private String getVehiclesHelper(String carType, String location, TimeInterval timeInterval) {
	    String query = "";
        if (carType != null && location != null && timeInterval != null) {
            query += " WHERE  v.vtname = " + carType;
            query += " AND v.location = " + location;
            query += " AND v.vlicence NOT IN ( " +
                    "SELECT r.vlicence " +
                    "FROM rentals r " +
                    "WHERE r.from >= " + timeInterval.getFromDate() +
                    " OR r.to <= " + timeInterval.getToDate() + ")";
        } else if (carType != null && location != null ) {
            query += " WHERE  v.vtname = " + carType;
            query += " AND v.location = " + location;
        } else if (location != null && timeInterval != null) {
            query += " WHERE v.location = " + location;
            query += " AND v.vlicence NOT IN ( " +
                    "SELECT r.vlicence " +
                    "FROM rentals r " +
                    "WHERE r.fromDate >= " + timeInterval.getFromDate() +
                    " OR r.toDate <= " + timeInterval.getToDate() + ")";
        } else if (carType != null && timeInterval != null) {
            query += " WHERE  v.vtname = " + carType;
            query += " AND v.vlicence NOT IN ( " +
                    "SELECT r.vlicence " +
                    "FROM rentals r " +
                    "WHERE r.from >= " + timeInterval.getFromDate() +
                    " OR r.to <= " + timeInterval.getToDate() + ")";
        } else if (carType != null ) {
            query += " WHERE  v.vtname = " + carType;
        } else if (location != null ) {
            query += " WHERE v.location = " + location;
        } else if (timeInterval != null) {
            query += " WHERE v.vlicence NOT IN ( " +
                    "SELECT r.vlicence " +
                    "FROM rentals r " +
                    "WHERE r.fromDate >= " + timeInterval.getFromDate() +
                    " OR r.toDate <= " + timeInterval.getToDate() + ")";
        }
        return query;
    }

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

	public int numberOfVehiclesNotRented(String carType, String location, TimeInterval timeInterval) {
		try {
			int result;
			String query = "SELECT count(*) FROM vehicles v";
            query += this.getVehiclesHelper(carType, location, timeInterval);

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			result = rs.getInt("total");

			rs.close();
			stmt.close();
			return result;
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			return -1;
		}
	}

	public int numberOfReservedVehicles(String carType, TimeInterval timeInterval) {
		try {
			int result;
			String query = "SELECT count(*) FROM reservations r";
			if (carType != null && timeInterval != null) {
				query += " WHERE r.vtname = " + carType;
				query += " AND r.fromDate >= " + timeInterval.getFromDate();
				query += " AND r.toDate <= " + timeInterval.getToDate();
			} else if (carType != null) {
				query += " WHERE r.vtname = " + carType;
			} else if (timeInterval != null) {
				query += " WHERE r.fromDate >= " + timeInterval.getFromDate();
				query += " AND r.toDate <= " + timeInterval.getToDate();
			}

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			result = rs.getInt("total");

			rs.close();
			stmt.close();
			return result;
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			return -1;
		}
	}
}
