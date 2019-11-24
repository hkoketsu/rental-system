package ca.ubc.cs304.tests;

import ca.ubc.cs304.database.CustomerHandler;
import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.delegates.LoginWindowDelegate;
import ca.ubc.cs304.delegates.TerminalTransactionsDelegate;
import ca.ubc.cs304.model.BranchModel;
import ca.ubc.cs304.model.TimeInterval;
import ca.ubc.cs304.model.VehicleModel;
import ca.ubc.cs304.ui.LoginWindow;

import java.sql.Date;

/**
 * This is the main controller class that will orchestrate everything.
 */
public class ManualTests implements LoginWindowDelegate, TerminalTransactionsDelegate {
	private DatabaseConnectionHandler dbHandler = null;
	private LoginWindow loginWindow = null;

	public ManualTests() {
		dbHandler = new DatabaseConnectionHandler();
	}
	
	private void start() {
		login("ora_gast300", "a47448337");  // dont hack me dude
		CustomerHandler customerHandler = new CustomerHandler(dbHandler);
		if ( !customerHandler.isCustomerInDatabase("QK06-N418Q")) {
            System.out.println("should have been true");
            System.exit(-1);
        }else if (customerHandler.isCustomerInDatabase("AAAAHHHHH")) {
            System.out.println("should have been false");
		    System.exit(-1);
        }
		// customerHandler.addCustomerToDatabase("a", "b", "c", "d");
		int vCount = customerHandler.viewNumberOfVehicles(null, null, null);
		if (vCount != 50) {
			System.out.println("total should be 50 is: " + vCount);
			System.exit(-1);
		}
		vCount = customerHandler.viewNumberOfVehicles("Truck", null, null);
		if (vCount != 16) {
			System.out.println("total should be 16 is: " + vCount);
			System.exit(-1);
		}
		vCount = customerHandler.viewNumberOfVehicles(null, "5202 Union St", null);
		if (vCount != 26) {
			System.out.println("total should be 26 is: " + vCount);
			System.exit(-1);
		}
		vCount = customerHandler.viewNumberOfVehicles("Truck", "5202 Union St", null);
		if (vCount != 9) {
			System.out.println("total should be 9 is: " + vCount);
			System.exit(-1);
		}
		TimeInterval t = new TimeInterval(new Date(0, 0, 1), new Date(8000, 0, 1), "a", "b");
		vCount = customerHandler.viewNumberOfVehicles(null, null, t);
		if (vCount != 35) { // 35 vehicles are not rented
			System.out.println("total should be 0 is: " + vCount);
			System.exit(-1);
		}
		t = new TimeInterval(new Date(119, 9, 1), new Date(119, 9, 10), "a", "b");
		vCount = customerHandler.viewNumberOfVehicles(null, null, t);
		if (vCount != 47) {
			System.out.println("total should be 15 is: " + vCount);
			System.exit(-1);
		}
		t = new TimeInterval(new Date(119, 9, 8), new Date(119, 9, 19), "a", "b");
		vCount = customerHandler.viewNumberOfVehicles("Truck", null, t);
		if (vCount != 15) {
			System.out.println("total should be 15 is: " + vCount);
			System.exit(-1);
		}
		t = new TimeInterval(new Date(0, 0, 1), new Date(8000, 0, 1), "a", "b");
		vCount = customerHandler.viewNumberOfVehicles("Truck", null, t);
		if (vCount != 0) { // 35 vehicles are not rented
			System.out.println("total should be 0 is: " + vCount);
			System.exit(-1);
		}

		VehicleModel[] models = customerHandler.viewVehicles(null, null, null);
		if (models.length != 50) {
            System.out.println("total should be 50 is: " + models.length);
            System.exit(-1);
        }
		if (!customerHandler.isVehicleAvailable("6666655133", null)) {
			System.out.println("should be true");
			System.exit(-1);
		}
//		customerHandler.addCustomerToDatabase("123", "250-", "Matt", "AAAAHHH");
//		String confNo = customerHandler.makeReservation( "Matt Car", "123", new TimeInterval(new Date(0), new Date(0), "", ""));
		int stop;
	}
	
	/**
	 * LoginWindowDelegate Implementation
	 * 
     * connects to Oracle database with supplied username and password
     */ 
	public void login(String username, String password) {
		boolean didConnect = dbHandler.login(username, password);

		if (didConnect) {
			// Once connected, remove login window and start text transaction flow
			// loginWindow.dispose();

			// TerminalTransactions transaction = new TerminalTransactions();
			// transaction.showMainMenu(this);
		} else {
			// System.out.println("Failed to login");
			System.exit(-1);
		}
	}
	
	/**
	 * TermainalTransactionsDelegate Implementation
	 * 
	 * Insert a branch with the given info
	 */
    public void insertBranch(BranchModel model) {
    	dbHandler.insertBranch(model);
    }

    /**
	 * TermainalTransactionsDelegate Implementation
	 * 
	 * Delete branch with given branch ID.
	 */ 
    public void deleteBranch(int branchId) {
    	dbHandler.deleteBranch(branchId);
    }
    
    /**
	 * TermainalTransactionsDelegate Implementation
	 * 
	 * Update the branch name for a specific ID
	 */

    public void updateBranch(int branchId, String name) {
    	dbHandler.updateBranch(branchId, name);
    }

    /**
	 * TermainalTransactionsDelegate Implementation
	 * 
	 * Displays information about varies bank branches.
	 */
    public void showBranch() {
    	BranchModel[] models = dbHandler.getBranchInfo();
    	
    	for (int i = 0; i < models.length; i++) {
    		BranchModel model = models[i];
    		
    		// simplified output formatting; truncation may occur
    		System.out.printf("%-10.10s", model.getId());
    		System.out.printf("%-20.20s", model.getName());
    		if (model.getAddress() == null) {
    			System.out.printf("%-20.20s", " ");
    		} else {
    			System.out.printf("%-20.20s", model.getAddress());
    		}
    		System.out.printf("%-15.15s", model.getCity());
    		if (model.getPhoneNumber() == 0) {
    			System.out.printf("%-15.15s", " ");
    		} else {
    			System.out.printf("%-15.15s", model.getPhoneNumber());
    		}
    		
    		System.out.println();
    	}
    }
	
    /**
	 * TerminalTransactionsDelegate Implementation
	 * 
     * The TerminalTransaction instance tells us that it is done with what it's 
     * doing so we are cleaning up the connection since it's no longer needed.
     */ 
    public void terminalTransactionsFinished() {
    	dbHandler.close();
    	dbHandler = null;
    	
    	System.exit(0);
    }
    
	/**
	 * Main method called at launch time
	 */
	public static void main(String args[]) {
		ManualTests bank = new ManualTests();
		bank.start();
	}
}
