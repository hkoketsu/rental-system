package ca.ubc.cs304.controller;

import ca.ubc.cs304.model.RentalReceipt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/***
 * Page for displaying rental completion
 */
public class PageController5ba extends PageController implements Initializable {
    @FXML Label customerNameLabel;
    @FXML Label rentalIdLabel;
    @FXML Label confNoLabel;
    @FXML Label vehicleTypeLabel;
    @FXML Label branchLabel;
    @FXML Label pickupLabel;
    @FXML Label returnLabel;


    private RentalReceipt rentalReceipt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerNameLabel.setText(rentalReceipt.getCustomerName());
        confNoLabel.setText(rentalReceipt.getConfNo());
        rentalIdLabel.setText(rentalReceipt.getRentalId());
        vehicleTypeLabel.setText(rentalReceipt.getVehicleType());
        pickupLabel.setText(rentalReceipt.getPickupDateTime());
        returnLabel.setText(rentalReceipt.getReturnDateTime());
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 1) {
            rentalReceipt = (RentalReceipt) params[0][0];
        }
    }

    public void onClickTopButton() {
        setPage(PageController2b.class, "1");
    }
}
