package ca.ubc.cs304.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	private static final String username = "ora_abramwwy";
	private static final String password = "a46086161";

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

    public Vehicle[] getVehicles(String carType, String location, TimeInterval timeInterval) { return vehicleRepository.getVehicles(carType, location, timeInterval); }

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
}