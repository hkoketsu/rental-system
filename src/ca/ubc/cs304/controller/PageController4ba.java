package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.*;
import ca.ubc.cs304.model.RentalReceipt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.util.List;
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
    @FXML ChoiceBox vehicleIdChoiceBox;

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

    private Customer customer;
    private Reservation reservation;

    private DatabaseConnectionHandler dbHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbHandler = new DatabaseConnectionHandler();
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 2) {
            reservation = (Reservation) params[0][0];
            branch = params[0][1].toString();

            vehicleType = reservation.getVehicleType();
            TimeInterval duration = reservation.getDuration();
            pickupDateTime = duration.getFromDate().toString() + " " + duration.getFromTime();
            returnDateTime = duration.getToDate().toString() + " " + duration.getToTime();

            String customerId = reservation.getCustomerId();
            customer = dbHandler.getCustomer(customerId);

            vehicleTypeLabel.setText(vehicleType);
            branchLabel.setText(branch);
            pickupLabel.setText(pickupDateTime);
            returnLabel.setText(returnDateTime);

            TimeInterval timeInterval = new TimeInterval(
                    Date.valueOf(pickupDateTime.split(" ")[0]),
                    Date.valueOf(returnDateTime.split(" ")[0]),
                    pickupDateTime.split(" ")[1],
                    returnDateTime.split(" ")[1]
            );
            List<String> vehicleIds = dbHandler.getAvailableVehicleIds(
                    vehicleType,
                    branch,
                    timeInterval
            );
            ObservableList<String> vehicleIdItems = FXCollections.observableArrayList(vehicleIds);
            vehicleIdChoiceBox.setItems(vehicleIdItems);
        }
    }

    public void onClickProceed() {
        String creditName = creditNameTextField.getText();
        String creditNumber = creditNumberTextField.getText();
        String expDate = expDateTextField.getText();
        CreditCard creditCard = new CreditCard(creditName, creditNumber, expDate);
        String odometer = odometerTextField.getText();
        Object vehicleId = vehicleIdChoiceBox.getValue();

        if (creditName.equals("")|| creditNumber.equals("") || expDate.equals("") || odometer.equals("") || vehicleId == null) {
            errorLabel.setVisible(true);
        } else {
            String rentalId = Util.generateRentalId();
            Rental rental = new Rental(
                    rentalId,
                    vehicleId.toString(),
                    reservation.getCustomerId(),
                    reservation.getDuration(),
                    Integer.parseInt(odometer),
                    creditCard,
                    reservation.getId()
            );
            dbHandler.putRental(rental);
            String customerName = dbHandler.getCustomer(reservation.getCustomerId()).getName();
            RentalReceipt receipt = new RentalReceipt(rentalId, reservation.getId(), customerName, pickupDateTime, returnDateTime, vehicleType, branch);
            setPage(PageController5ba.class, "5ba", new RentalReceipt[]{receipt});
        }
    }

    public void onClickBackButton() {
        setPage(PageController3ba.class, "3ba");
    }
}
