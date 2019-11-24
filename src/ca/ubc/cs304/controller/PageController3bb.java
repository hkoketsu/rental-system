package ca.ubc.cs304.controller;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Boolean> booleans = FXCollections.observableArrayList(true, false);
        gasTankFullChoiceBox.setItems(booleans);
    }

    public void onClickProceedButton() {
        String rentalId = rentalIdTextField.getText();
        String odometer = odometerTextField.getText();
        boolean fullTank = gasTankFullChoiceBox.getValue();

        if (rentalId == null || odometer == null) {
            errorLabel.setVisible(true);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm:ss");
            String dateTime = LocalDateTime.now().format(formatter);
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date(df.parse(dateTime.split(" ")[0]).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String time = dateTime.split(" ")[1];
            // TODO: send query to add to return
            setPage(PageController4bb.class, "4bb", new String[]{rentalId, dateTime});
        }
    }

    public void onClickBackButton() {
        setPage(PageController2b.class, "2b");
    }
}
