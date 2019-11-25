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
    private String branch;
    private String pickupDateTime;
    private String returnDateTime;

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 4) {
            String[] paramsStr = (String[]) params[0];
            vehicleType = paramsStr[0];
            branch = paramsStr[1];
            pickupDateTime = paramsStr[2];
            returnDateTime = paramsStr[3];

            vehicleTypeLabel.setText(vehicleType);
            branchLabel.setText(branch);
            pickupLabel.setText(pickupDateTime);
            returnLabel.setText(returnDateTime);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vehicleTypeLabel.setText(vehicleType);
        branchLabel.setText(branch);
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
            DatabaseConnectionHandler dbHandler = new DatabaseConnectionHandler();
            CustomerHandler customerHandler = new CustomerHandler(dbHandler);
            if ( ! customerHandler.isCustomerInDatabase(licenseNumber) ) {
                customerHandler.addCustomerToDatabase(licenseNumber, phoneNumber, name, address);
            }
            dbHandler.close();

            setPage(PageController5a.class, "5a", new String[]{vehicleType, licenseNumber, pickupDateTime, returnDateTime});
        }
    }

    public void onClickBackButton() {
        setPage(PageController2a.class, "2a");
    }
}
