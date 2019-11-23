package ca.ubc.cs304.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/***
 * Page for searching vehicles
 */
public class PageController2a extends PageController implements Initializable {
    @FXML ChoiceBox<String> vehicleTypeChoices;
    @FXML ChoiceBox<String> branchChoices;
    @FXML DatePicker pickupDatePicker;
    @FXML ChoiceBox<String> pickupTimeChoices;
    @FXML DatePicker returnDatePicker;
    @FXML ChoiceBox<String> returnTimeChoices;
    @FXML Button searchButton;

    @FXML Label vehicleTypeLabel;
    @FXML Label branchLabel;
    @FXML Label pickupLabel;
    @FXML Label returnLabel;
    @FXML Label resultLabel;
    @FXML TableView resultTable;

    @FXML Pane resultPane;

    @FXML ScrollPane noConditionPane;
    @FXML Label noConditionLabel;

    @FXML Button reserveButton;

    private String vehicleType;
    private String branch;
    private String pickupDateTime;
    private String returnDateTime;

    private boolean byClerk;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> vehicleTypes = FXCollections.observableArrayList(
        "Economy", "Compact", "Mid-size", "Standard", "Fullsize", "SUV", "Truck"
        );
        vehicleTypeChoices.setItems(vehicleTypes);
//        ObservableList<String> branches = TODO: get all branches by SQL
        ObservableList<String> branches = FXCollections.observableArrayList("test branch");
        branchChoices.setItems(branches);
        ObservableList<String> hours = FXCollections.observableArrayList(
                "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00",
                    "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"
                );
        pickupTimeChoices.setItems(hours);
        returnTimeChoices.setItems(hours);
    }

    public void onClickSearchButton() {
        String vehicleType = vehicleTypeChoices.getValue();
        String branch = branchChoices.getValue();
        LocalDate pickUpDate = pickupDatePicker.getValue();
        LocalDate returnDate = returnDatePicker.getValue();
        String  pickupTime = pickupTimeChoices.getValue();
        String returnTime = returnTimeChoices.getValue();

        resultPane.setVisible(true);

        if (vehicleType != null) {
            this.vehicleType = vehicleType;
            vehicleTypeLabel.setText(vehicleType);
        }
        if (branch != null) {
            this.branch = branch;
            branchLabel.setText(branch);
        }
        if (pickUpDate != null && pickupTime != null) {
            pickupDateTime = pickUpDate.toString() + " " + pickupTime;
            pickupLabel.setText(pickupDateTime);
        }
        if (returnDate != null && returnTime != null) {
            returnDateTime = returnDate.toString() + " " + returnTime;
            returnLabel.setText(returnDateTime);
        }
        if (vehicleType != null && branch != null && pickUpDate != null && pickupTime != null && returnDate != null && returnTime != null) {
            reserveButton.setVisible(true);
        } else {
            reserveButton.setVisible(false);
        }

        // TODO: get search result, put the result on resultLabel and resultTable
        // TODO: and depending on the result, change the page contents
    }

    public void onClickReserveButton() {
        if (byClerk) {
            setPage(PageController4ab.class, "4ab", new String[]{vehicleType, branch, pickupDateTime, returnDateTime});
        }
        else {
            setPage(PageController4a.class, "4a", new String[]{vehicleType, branch, pickupDateTime, returnDateTime});
        }
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params[0] != null) {
            byClerk = (boolean) params[0][0];
        }
    }
}
