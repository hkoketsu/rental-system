package ca.ubc.cs304.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/***
 * Page for displaying return receipt
 */
public class PageController4bb extends PageController implements Initializable {
    @FXML Label rentalIdLabel;
    @FXML Label dateLabel;
    @FXML Label totalPriceLabel;

    private String rentalId;
    private String returnDateTime;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rentalIdLabel.setText(rentalId);
        dateLabel.setText(returnDateTime);
        int price = 0;
        // TODO: calculate price based on rental ID
        totalPriceLabel.setText(String.valueOf(price));
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 2) {
            String[] paramsStr = (String[]) params[0];
            rentalId = paramsStr[0];
            returnDateTime = paramsStr[1];
        }
    }

    public void onClickTopButton() {
        setPage(PageController2b.class, "2b");
    }
}
