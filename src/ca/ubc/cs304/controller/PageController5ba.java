package ca.ubc.cs304.controller;

import ca.ubc.cs304.domain.receipt.RentalReceipt;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/***
 * Page for displaying rental completion
 */
public class PageController5ba extends PageController {
    @FXML Label customerNameLabel;
    @FXML Label rentalIdLabel;
    @FXML Label confNoLabel;
    @FXML Label vehicleTypeLabel;
    @FXML Label branchLabel;
    @FXML Label pickupLabel;
    @FXML Label returnLabel;

    private RentalReceipt rentalReceipt;


    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 1) {
            rentalReceipt = (RentalReceipt) params[0][0];
        }
        customerNameLabel.setText(rentalReceipt.getCustomerName());
        confNoLabel.setText(rentalReceipt.getConfNo());
        rentalIdLabel.setText(rentalReceipt.getRentalId());
        vehicleTypeLabel.setText(rentalReceipt.getVehicleType());
        pickupLabel.setText(rentalReceipt.getPickupDateTime());
        returnLabel.setText(rentalReceipt.getReturnDateTime());
    }

    public void onClickTopButton() {
        setPage(PageController2b.class, "1");
    }
}
