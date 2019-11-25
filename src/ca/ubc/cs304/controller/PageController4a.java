package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.service.CustomerHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/***
 * Page for adding customer information for reservation
 */
public class PageController4a extends PageController implements Initializable {
    @FXML Label vehicleTypeLabel;
    @FXML Label branchLabel;
    @FXML Label pickupLabel;
    @FXML Label returnLabel;

    @FXML TextField nameTextField;
    @FXML TextField phoneNumberTextField;
    @FXML TextField driverLicenseTextField;
    @FXML TextField addressTextField;

    @FXML Button proceedButton;

    @FXML Label errorLabel;

    private String vehicleType;
    private String pickupDateTime;
    private String returnDateTime;
    private String branchLocation;

    private DatabaseConnectionHandler dbHandler;
    private CustomerHandler customerHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbHandler = new DatabaseConnectionHandler();
        customerHandler = new CustomerHandler(dbHandler);
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 4) {
            String[] paramsStr = (String[]) params[0];
            vehicleType = paramsStr[0];
            branchLocation = paramsStr[1];
            pickupDateTime = paramsStr[2];
            returnDateTime = paramsStr[3];
        }
        vehicleTypeLabel.setText(vehicleType);
        branchLabel.setText(branchLocation);
        pickupLabel.setText(pickupDateTime);
        returnLabel.setText(returnDateTime);
    }

    public void onClickProceed() {
        String name = nameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String licenseNumber = driverLicenseTextField.getText();
        String address  = addressTextField.getText();

        if (name.equals("") || phoneNumber.equals("") || licenseNumber.equals("") || address.equals("")) {
            errorLabel.setVisible(true);
        } else {

            // TODO: consider moving this somewhere better
            if ( ! customerHandler.isCustomerInDatabase(licenseNumber) ) {
                customerHandler.addCustomerToDatabase(licenseNumber, phoneNumber, name, address);
            }
//            dbHandler.close();

            setPage(PageController5a.class, "5a", new String[]{vehicleType, licenseNumber, pickupDateTime, returnDateTime});
        }
    }

    public void onClickBackButton() {
        setPage(PageController2a.class, "2a");
    }
}
