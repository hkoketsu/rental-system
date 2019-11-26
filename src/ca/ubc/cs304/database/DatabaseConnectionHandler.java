package ca.ubc.cs304.database;

import java.sql.*;
import java.util.List;

import ca.ubc.cs304.domain.*;
import ca.ubc.cs304.domain.reports.RentalBranchReport;
import ca.ubc.cs304.domain.reports.RentalReport;
import ca.ubc.cs304.domain.reports.ReturnBranchReport;
import ca.ubc.cs304.domain.reports.ReturnReport;
import ca.ubc.cs304.repository.*;

/**
 * This class handles all database related transactions
 */
public class DatabaseConnectionHandler {
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
	private static final String EXCEPTION_TAG = "[EXCEPTION]";
	private static final String WARNING_TAG = "[WARNING]";
	private static final String username = "ora_hkoketsu";
	private static final String password = "a93547966";

	private static Connection connection;
	private BranchRepository branchRepository;
	private CustomerRepository customerRepository;
	private RentalRepository rentalRepository;
	private ReservationRepository reservationRepository;
	private ReturnRepository returnRepository;
	private VehicleRepository vehicleRepository;
	private VehicleTypeRepository vehicleTypeRepository;
	private RentalReportRepository rentalReportRepository;
	private ReturnReportRepository returnReportRepository;

	public DatabaseConnectionHandler() {
		getConnection();
		branchRepository = new BranchRepository(connection);
		customerRepository = new CustomerRepository(connection);
		rentalRepository = new RentalRepository(connection);
		reservationRepository = new ReservationRepository(connection);
		returnRepository = new ReturnRepository(connection);
		vehicleRepository = new VehicleRepository(connection);
		vehicleTypeRepository = new VehicleTypeRepository(connection);
		rentalReportRepository = new RentalReportRepository(connection);
		returnReportRepository = new ReturnReportRepository(connection);
	}

	public List<String> getBranchLocations(String city) { return branchRepository.getBranchLocations(city); }

    public List<String> getBranchLocations() { return branchRepository.getBranchLocations(); }

	public List<String> getCityInfo() { return branchRepository.getCityInfo(); }

    public Vehicle getRentedVehicle(String vlicense, TimeInterval timeInterval) { return vehicleRepository.getRentedVehicle(vlicense, timeInterval); }

	public Reservation getReservation(String cfNumber) {
		return reservationRepository.getReservation(cfNumber);
	}

	public Rental getRentalInfo(String id) { return rentalRepository.getRentalInfo(id); }

	public boolean checkReturn(String id) { return returnRepository.checkReturnEntry(id); }

	public void putRental(Rental rental) { rentalRepository.rentVehicle(rental); }

	public void putReturn(Return returnObj) { returnRepository.returnVehicle(returnObj); }

    public void putCustomer(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    public void putReservation(Reservation reservation) {
        reservationRepository.insertReservation(reservation);
    }

    public Customer getCustomer(String dlicense) {
        return customerRepository.getCustomer(dlicense);
    }

    public String[] getReservationConfnoInfo() {
        return reservationRepository.getReservationConfnoInfo();
    }

    public Vehicle getVehicle(String id) { return vehicleRepository.getVehicle(id); }

    public List<Vehicle> getVehicles(String carType, String location, TimeInterval timeInterval) { return vehicleRepository.getVehicles(carType, location, timeInterval); }

    public List<String> getAvailableVehicleIds(String carType, String location, TimeInterval timeInterval) { return vehicleRepository.getAvailableVehicleIds(carType, location, timeInterval); }

    public int getNumberOfVehiclesNotRented(String carType, String location, TimeInterval timeInterval) { return vehicleRepository.numberOfVehiclesNotRented(carType, location, timeInterval); }

    public int getNumberOfReservedVehicles(String carType, TimeInterval timeInterval) { return vehicleRepository.numberOfReservedVehicles(carType,timeInterval); }

    public VehicleType getVehicleTypeObj(String id) { return vehicleTypeRepository.getVehicleTypeObj(id); }

    public RentalReport getRentalReport(Date date) { return rentalReportRepository.getRentalReport(date); }

    public RentalBranchReport getRentalBranchReport(Date date, String location, String city) {return rentalReportRepository.getBranchRentalReport(date, location, city);}

    public ReturnReport getReturnReport(Date date) {return returnReportRepository.getReturnReport(date);}

	public ReturnBranchReport getReturnBranchReport(Date date, String location, String city) {return returnReportRepository.getBranchReturnReport(date, location, city);}

    public static void rollbackConnection() {
        try  {
            connection.rollback();
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

	private void getConnection() {
		if (connection != null) {
			return;
		}
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(ORACLE_URL, username, password);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void viewVehicles () {
		try {

			String query = "select * from vehicles";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			System.out.println("##################vehicles##################");
			while(rs.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("vlicense: " + rs.getString("vlicense"));
				System.out.println("make: " + rs.getString("make"));
				System.out.println("model: " + rs.getString("model"));
				System.out.println("year: " + rs.getInt("year"));
				System.out.println("color: " + rs.getString("color"));
				System.out.println("odometer: " + rs.getInt("odometer"));
				System.out.println("vtname: " + rs.getString("vtname"));
				System.out.println("location: " + rs.getString("location"));
				System.out.println("city: " + rs.getString("city"));
				System.out.println("status: " + rs.getString("status"));
				System.out.println("------------------------------------------------");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewBranch(){
		try {

			String query = "select * from branch";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			System.out.println("##################branch##################");
			while(rs.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("location: " + rs.getString("location"));
				System.out.println("city: " + rs.getString("city"));
				System.out.println("------------------------------------------------");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewVehiclesTypes () {
		try {

			String query = "select * from vehicleTypes";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			System.out.println("##################vehicleTypes##################");
			while(rs.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("vtname: " + rs.getString("vtname"));
				System.out.println("features: " + rs.getString("features"));
				System.out.println("wrate: " + rs.getInt("wrate"));
				System.out.println("drate: " + rs.getInt("drate"));
				System.out.println("hrate: " + rs.getInt("hrate"));
				System.out.println("wirate: " + rs.getInt("wirate"));
				System.out.println("dirate: " + rs.getInt("dirate"));
				System.out.println("hirate: " + rs.getInt("hirate"));
				System.out.println("krate: " + rs.getInt("krate"));
				System.out.println("------------------------------------------------");
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewCustomers () {
		try {

			String query = "select * from customers";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			System.out.println("##################customers##################");
			while(rs.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("dlicense: " + rs.getString("dlicense"));
				System.out.println("cellphone: " + rs.getString("cellphone"));
				System.out.println("name: " + rs.getString("name"));
				System.out.println("address: " + rs.getString("address"));
				System.out.println("------------------------------------------------");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewReservations() {
		try {

			String query = "select * from reservations";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);


			System.out.println("##################reservations##################");
			while(rs.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("confNo: " + rs.getString("confNo"));
				System.out.println("vtname: " + rs.getString("vtname"));
				System.out.println("dlicense: " + rs.getString("dlicense"));
				System.out.println("fromDate: " + rs.getDate("fromDate"));
				System.out.println("fromTime: " + rs.getString("fromTime"));
				System.out.println("toDate: " + rs.getDate("toDate"));
				System.out.println("toTime: " + rs.getString("toTime"));
				System.out.println("------------------------------------------------");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewRentals() {
		try {

			String query = "select * from rentals";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			System.out.println("##################rentals##################");
			while(rs.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("rid: " + rs.getString("rid"));
				System.out.println("vlicense: " + rs.getString("vlicense"));
				System.out.println("dlicense: " + rs.getString("dlicense"));
				System.out.println("fromDate: " + rs.getDate("fromDate"));
				System.out.println("fromTime: " + rs.getString("fromTime"));
				System.out.println("toDate: " + rs.getDate("toDate"));
				System.out.println("toTime: " + rs.getString("toTime"));
				System.out.println("odometer: " + rs.getInt("odometer"));
				System.out.println("cardName: " + rs.getString("cardName"));
				System.out.println("cardNo: " + rs.getString("cardNo"));
				System.out.println("expDate: " + rs.getString("expDate"));
				System.out.println("confNo: " + rs.getString("confNo"));
				System.out.println("------------------------------------------------");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewReturns() {
		try {

			String query = "select * from returns";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);


			System.out.println("##################returns##################");
			while(rs.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("rid: " + rs.getString("rid"));
				System.out.println("rdate: " + rs.getDate("rdate"));
				System.out.println("rtime: " + rs.getString("rtime"));
				System.out.println("odometer: " + rs.getInt("odometer"));
				System.out.println("fulltank: " + rs.getString("fulltank"));
				System.out.println("value: " + rs.getInt("value"));
				System.out.println("------------------------------------------------");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewAllTables(){
		viewBranch();
		viewVehicles();
		viewVehiclesTypes();
		viewCustomers();
		viewRentals();
		viewReservations();
		viewReturns();
	}


	public void insertBranch(Branch model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO branch VALUES (?,?)");
			ps.setString(1, model.getLocation());
			ps.setString(2, model.getCity());

			ps.executeUpdate();
			connection.commit();

			ps.close();
			System.out.println("SUCCESS!");
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertVehicles(Vehicle model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO vehicles VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, model.getVlicense());
			ps.setString(2, model.getMake());
			ps.setString(3, model.getModel());
			ps.setInt(4, Integer.getInteger(model.getYear()));
			ps.setString(5, model.getColor());
			ps.setInt(6, Integer.getInteger(model.getOdometer()));
			ps.setString(7, model.getVtname());
			ps.setString(8, model.getLocation());
			ps.setString(9, model.getCity());
			ps.setString(10, model.getStatus());

			ps.executeUpdate();
			connection.commit();

			ps.close();
			System.out.println("SUCCESS!");
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertVehicleTypes(VehicleType model) {
		try {
			InsuranceRate iRate = model.getInsuranceRate();
			VehicleRate vRate = model.getVehicleRate();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO vehicleTypes VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, model.getId());
			ps.setString(2, model.getFeatures());
			ps.setInt(3, vRate.getWeekRate());
			ps.setInt(4, vRate.getDayRate());
			ps.setInt(5, vRate.getHourRate());
			ps.setInt(6, iRate.getWeekRate());
			ps.setInt(7, iRate.getDayRate());
			ps.setInt(8, iRate.getHourRate());
			ps.setInt(9, model.getKmRate());

			ps.executeUpdate();
			connection.commit();

			ps.close();
			System.out.println("SUCCESS!");
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertCustomers(String dlicense, String cellphone, String name, String address) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO vehicleTypes VALUES (?,?,?,?)");
			ps.setString(1, dlicense);
			ps.setString(2, cellphone);
			ps.setString(3, name);
			ps.setString(4, address);

			ps.executeUpdate();
			connection.commit();

			ps.close();
			System.out.println("SUCCESS!");
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertReservation() {
		System.out.println("for the sake of time, insert through normal gui");
//		try {
//			PreparedStatement ps = connection.prepareStatement("INSERT INTO vehicleTypes VALUES (?,?,?,?)");
//			ps.setString(1, model.get);
//
//			ps.executeUpdate();
//			connection.commit();
//
//			ps.close();
//			System.out.println("SUCCESS!");
//		} catch (SQLException e) {
//			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
//			rollbackConnection();
//		}
	}

	public void insertRental() {
		System.out.println("for the sake of time, insert through normal gui");
//		try {
//			PreparedStatement ps = connection.prepareStatement("INSERT INTO vehicleTypes VALUES (?,?,?,?)");
//			ps.setString(1, model.get);
//
//			ps.executeUpdate();
//			connection.commit();
//
//			ps.close();
//			System.out.println("SUCCESS!");
//		} catch (SQLException e) {
//			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
//			rollbackConnection();
//		}
	}

	public void insertReturn() {
		System.out.println("for the sake of time, insert through normal gui");
//		try {
//			PreparedStatement ps = connection.prepareStatement("INSERT INTO vehicleTypes VALUES (?,?,?,?)");
//			ps.setString(1, model.get);
//
//			ps.executeUpdate();
//			connection.commit();
//
//			ps.close();
//			System.out.println("SUCCESS!");
//		} catch (SQLException e) {
//			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
//			rollbackConnection();
//		}
	}



	public void deleteBranch(String location, String city) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM branch b WHERE b.location = ? AND b.city = ?");
			ps.setString(1, location);
			ps.setString(2, city);

			int rowCount = ps.executeUpdate();
			connection.commit();

			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " does not exist!");
			} else {
				System.out.println("SUCCESS!");
			}


			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteVehicle(String vlicense) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM vehicles v WHERE v.vlicense= ?");
			ps.setString(1, vlicense);

			int rowCount = ps.executeUpdate();

			connection.commit();


			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " does not exist!");
			} else {
				System.out.println("SUCCESS!");
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteVehicleType(String vtname) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM vehicleTypes v WHERE v.vtname = ?");
			ps.setString(1, vtname);

			int rowCount = ps.executeUpdate();

			connection.commit();


			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " does not exist!");
			} else {
				System.out.println("SUCCESS!");
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}


	public void deleteCustomer(String dlicense) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM customers c WHERE c.dlicense = ?");
			ps.setString(1, dlicense);

			int rowCount = ps.executeUpdate();

			connection.commit();


			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " does not exist!");
			} else {
				System.out.println("SUCCESS!");
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteReservation(String confNo) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM reservations r WHERE r.confNo = ?");
			ps.setString(1, confNo);

			int rowCount = ps.executeUpdate();

			connection.commit();


			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " does not exist!");
			} else {
				System.out.println("SUCCESS!");
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteRental(String rid) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM rentals r WHERE r.rid = ?");
			ps.setString(1, rid);

			int rowCount = ps.executeUpdate();

			connection.commit();

			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " does not exist!");
			} else {
				System.out.println("SUCCESS!");
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteReturn(String rid) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM returns r WHERE r.rid = ?");
			ps.setString(1, rid);

			int rowCount = ps.executeUpdate();
			connection.commit();

			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " does not exist!");
			} else {
				System.out.println("SUCCESS!");
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void updateCustomer(Customer model) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE customers SET cellphone = ? , name = ? , address = ?  WHERE dlicense = ?");
			ps.setString(1, model.getCellphone());
			ps.setString(2, model.getName());
			ps.setString(3, model.getAddress());
			ps.setString(4, model.getDlicense());

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " does not exist!");
			}

			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

}