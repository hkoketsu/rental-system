package ca.ubc.cs304.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/***
 * Page for rent with reservation
 * Input for confirmation number
 */
public class PageController3ba extends PageController {
    @FXML TextField confirmationNumberTextField;
    @FXML Label errorLabel;

    public void onClickNextButton() {
        String confirmationNumber = confirmationNumberTextField.getText();
        // TODO: send query to get the reservation information with the confirmation number
        // TODO: if found, goto 4ba, else set error label visible
        setPage(PageController4ba.class, "4ba", new String[]{confirmationNumber});
    }
}
