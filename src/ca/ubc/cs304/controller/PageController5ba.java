package ca.ubc.cs304.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PageController5ba extends PageController implements Initializable {
    @FXML Label customerNameLabel;
    @FXML Label rentalIdLabel;
    @FXML Label vehicleTypeLabel;
    @FXML Label branchLabel;
    @FXML Label pickupLabel;
    @FXML Label returnLabel;

    private String customerName;
    private String rentalId;
    private String vehicleType;
    private String pickupDateTime;
    private String returnDateTime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerNameLabel.setText(customerName);
        rentalIdLabel.setText(rentalId);
        vehicleTypeLabel.setText(vehicleType);
        pickupLabel.setText(pickupDateTime);
        returnLabel.setText(returnDateTime);
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 5) {
            String[] paramsStr = (String[]) params[0];
            customerName = paramsStr[0];
            rentalId = paramsStr[1];
            vehicleType = paramsStr[2];
            pickupDateTime = paramsStr[3];
            pickupDateTime = paramsStr[4];
        }
    }
}
