package ca.ubc.cs304.controller;

import ca.ubc.cs304.domain.receipt.ReturnReceipt;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


/***
 * Page for displaying return receipt
 */
public class PageController4bb extends PageController {
    @FXML Label rentalIdLabel;
    @FXML Label confNoLabel;
    @FXML Label dateLabel;

    @FXML Label totalPriceLabel;
    @FXML Label vehicleRateLabel;
    @FXML Label insuranceRateLabel;
    @FXML Label distanceRateLabel;

    private ReturnReceipt receipt;

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 1) {
            receipt = (ReturnReceipt) params[0][0];
        }
        rentalIdLabel.setText(receipt.getRentalId());
        confNoLabel.setText(receipt.getConfNo());
        dateLabel.setText(receipt.getDate().toString());
        totalPriceLabel.setText("$" + receipt.getTotalPrice());
        vehicleRateLabel.setText("$" + receipt.getVehicleRate());
        insuranceRateLabel.setText("$" + receipt.getInsuranceRate());
        distanceRateLabel.setText("$" + receipt.getDistanceRate());
    }

    public void onClickTopButton() {
        setPage(PageController1.class, "1");
    }
}
