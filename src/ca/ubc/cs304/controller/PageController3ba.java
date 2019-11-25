package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/***
 * Page for rent with reservation
 * Input for confirmation number
 */
public class PageController3ba extends PageController implements Initializable {
    @FXML TextField confirmationNumberTextField;
    @FXML Label errorLabel;

    private String branchLocation;
    private DatabaseConnectionHandler dbHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbHandler = new DatabaseConnectionHandler();
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 1) {
            branchLocation = params[0][0].toString();
        }
    }

    public void onClickNextButton() {
        String confirmationNumber = confirmationNumberTextField.getText();
        Reservation reservation = dbHandler.getReservation(confirmationNumber);
//        dbHandler.close();
        if (reservation != null) {
            setPage(PageController4ba.class, "4ba", new Object[]{reservation, branchLocation});
        } else {
            errorLabel.setVisible(true);
        }
    }
}
