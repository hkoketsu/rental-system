package ca.ubc.cs304.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/***
 * Page for displaying rental receipt
 */
public class PageController4ba extends PageController implements Initializable {
    @FXML Label vehicleTypeLabel;
    @FXML Label branchLabel;
    @FXML Label pickupLabel;
    @FXML Label returnLabel;
    @FXML TextField odometerTextField;

    @FXML Label nameLabel;
    @FXML Label phoneNumberLabel;
    @FXML Label driverLicenseLabel;
    @FXML TextField creditNameTextField;
    @FXML TextField creditNumberTextField;
    @FXML TextField expDateTextField;

    @FXML Button proceedButton;

    @FXML Label errorLabel;

    private String vehicleType;
    private String branch;
    private String pickupDateTime;
    private String returnDateTime;

    private String name;
    private String phoneNumber;
    private String driverLicenseNumber;

    private String confirmationNumber;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: get reservation with the confirmation number
        vehicleTypeLabel.setText(vehicleType);
        branchLabel.setText(branch);
        pickupLabel.setText(pickupDateTime);
        returnLabel.setText(returnDateTime);
    }

    public void onClickProceed() {
        String creditName = creditNameTextField.getText();
        String creditNumber = creditNumberTextField.getText();
        String expDate = expDateTextField.getText();

        String odometer = odometerTextField.getText();

        if (creditName.equals("")|| creditNumber.equals("") || expDate.equals("") || odometer.equals("")) {
            errorLabel.setVisible(true);
        } else {
//          TODO: send put query to Rent
            setPage(PageController5ba.class, "5ba", new String[] {name, vehicleType, branch, pickupDateTime, returnDateTime});
        }
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 1) {
            confirmationNumber = params[0][0].toString();
        }
    }

    public void onClickBackButton() {
        setPage(PageController3ba.class, "3ba");
    }
}
