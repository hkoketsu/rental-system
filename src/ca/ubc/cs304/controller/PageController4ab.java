package ca.ubc.cs304.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/***
 * Page for adding customer information when reservation was not ready
 */
public class PageController4ab extends PageController implements Initializable {
    @FXML Label vehicleTypeLabel;
    @FXML Label branchLabel;
    @FXML Label pickupLabel;
    @FXML Label returnLabel;
    @FXML TextField odometerTextField;

    @FXML TextField nameTextField;
    @FXML TextField phoneNumberTextField;
    @FXML TextField driverLicenseTextField;
    @FXML TextField creditNameTextField;
    @FXML TextField creditNumberTextField;
    @FXML TextField expDateTextField;

    @FXML
    Button proceedButton;

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
        String creditName = creditNameTextField.getText();
        String creditNumber = creditNumberTextField.getText();
        String expDate = expDateTextField.getText();

        String odometer = odometerTextField.getText();

        if (name == null || phoneNumber == null || licenseNumber == null || creditName == null || creditNumber == null || expDate == null || odometer == null) {
            errorLabel.setVisible(true);
        } else {
//          TODO: send put query to Rent
            setPage(PageController5ba.class, "5ba", new String[] {name, vehicleType, branch, pickupDateTime, returnDateTime});
        }
    }

    public void onClickBackButton() {
        setPage(PageController2a.class, "2a");
    }
}
