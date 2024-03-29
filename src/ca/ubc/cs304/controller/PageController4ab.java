package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.CreditCard;
import ca.ubc.cs304.domain.Rental;
import ca.ubc.cs304.domain.TimeInterval;
import ca.ubc.cs304.domain.Util;
import ca.ubc.cs304.domain.receipt.RentalReceipt;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
    @FXML ChoiceBox vehicleIdChoiceBox;

    @FXML TextField nameTextField;
    @FXML TextField phoneNumberTextField;
    @FXML TextField driverLicenseTextField;
    @FXML TextField creditNameTextField;
    @FXML TextField creditNumberTextField;
    @FXML TextField expDateTextField;

    @FXML Button proceedButton;

    @FXML Label errorLabel;

    private String vehicleType;
    private String branch;
    private String pickupDateTime;
    private String returnDateTime;

    private TimeInterval duration;

    private DatabaseConnectionHandler dbHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbHandler = new DatabaseConnectionHandler();
    }

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
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date pickupDate = new Date(df.parse(pickupDateTime.split(" ")[0]).getTime());
            Date returnDate = new Date(df.parse(returnDateTime.split(" ")[0]).getTime());
            String pickupTime = pickupDateTime.split(" ")[1];
            String returnTime = returnDateTime.split(" ")[1];
            duration = new TimeInterval(pickupDate, returnDate, pickupTime, returnTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> vehicleIds = dbHandler.getAvailableVehicleIds(
                vehicleType,
                branch,
                duration
        );
        ObservableList<String> vehicleIdItems = FXCollections.observableArrayList(vehicleIds);
        vehicleIdChoiceBox.setItems(vehicleIdItems);
    }

    public void onClickProceed() {
        String name = nameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String licenseNumber = driverLicenseTextField.getText();
        String creditName = creditNameTextField.getText();
        String creditNumber = creditNumberTextField.getText();
        String expDate = expDateTextField.getText();
        CreditCard creditCard = new CreditCard(creditName, creditNumber, expDate);

        String odometer = odometerTextField.getText();

        if (name.equals("") || phoneNumber.equals("") || licenseNumber.equals("")
                || creditName.equals("") || creditNumber.equals("") || expDate.equals("") || odometer.equals("")) {
            errorLabel.setVisible(true);
        } else {
            Rental rental = new Rental(
                    new Util(dbHandler).generateRentalId(),
                    vehicleIdChoiceBox.getValue().toString(),
                    licenseNumber,
                    duration,
                    Integer.parseInt(odometer),
                    creditCard,
                    null
            );
            dbHandler.putRental(rental);
            RentalReceipt receipt = new RentalReceipt(
                    rental.getId(),
                    null,
                    name,
                    pickupDateTime,
                    returnDateTime,
                    vehicleType,
                    branch
            );
            setPage(PageController5ba.class, "5ba", new Object[] {receipt});
        }
    }

    public void onClickBackButton() {
        setPage(PageController2a.class, "2a");
    }
}
