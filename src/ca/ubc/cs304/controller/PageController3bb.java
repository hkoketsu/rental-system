package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Rental;
import ca.ubc.cs304.domain.Return;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/***
 * Page for returning vehicle
 */
public class PageController3bb extends PageController implements Initializable {
    @FXML TextField rentalIdTextField;
    @FXML TextField odometerTextField;
    @FXML ChoiceBox<Boolean> gasTankFullChoiceBox;

    @FXML Label errorLabel;
    @FXML Label errorNotFoundLabel;

    private DatabaseConnectionHandler dbHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Boolean> booleans = FXCollections.observableArrayList(true, false);
        gasTankFullChoiceBox.setItems(booleans);
        dbHandler = new DatabaseConnectionHandler();
    }

    public void onClickProceedButton() {
        String rentalId = rentalIdTextField.getText();
        String odometer = odometerTextField.getText();
        boolean fullTank = gasTankFullChoiceBox.getValue();

//        Rental rental = dbHandler.getRentalInfo(rentalId);

        if (rentalId.equals("") || odometer.equals("")) {
            errorLabel.setVisible(true);
            errorNotFoundLabel.setVisible(false);
//        } else if (rental == null) {
//            errorLabel.setVisible(false);
//            errorNotFoundLabel.setVisible(true);
        }
        else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm");
            String dateTime = LocalDateTime.now().format(formatter);
            Date date;
            try {
                DateFormat df = new SimpleDateFormat("dd-MMM-yy");
                date = new Date(df.parse(dateTime.split(" ")[0]).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String time = dateTime.split(" ")[1];
//            dbHandler.putReturn(new Return(
//                    rentalId, date, time, odometer, fullTank,
//            ));

            setPage(PageController4bb.class, "4bb", new String[]{rentalId, dateTime});
        }
    }

    public void onClickBackButton() {
        setPage(PageController2b.class, "2b");
    }
}
