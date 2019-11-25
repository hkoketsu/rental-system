package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/***
 * Page for selecting a report type
 */
public class PageController3bc extends PageController implements Initializable {
    @FXML ChoiceBox<String> branchChoiceBox;
    @FXML Label errorLabel;

    private DatabaseConnectionHandler dbHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbHandler = new DatabaseConnectionHandler();
        List<String> branchLocations = dbHandler.getBranchLocations();
        ObservableList<String> branchItems = FXCollections.observableArrayList(branchLocations);
        branchChoiceBox.setItems(branchItems);
    }

    public void onClick(ActionEvent e) {
        Button button = (Button) e.getSource();
        String branch;
        switch (button.getId()) {
            case "CompanyRental":
                setPage(PageController4bca.class, "4bca", new String[]{"rental"});
                break;
            case "CompanyReturn":
                setPage(PageController4bca.class, "4bca", new String[]{"return"});
                break;
            case "BranchRental":
                if (branchChoiceBox.getValue() != null) {
                    branch = branchChoiceBox.getValue().toString();
                    setPage(PageController4bca.class, "4bcb", new String[]{"rental", branch});
                } else {
                    errorLabel.setVisible(true);
                }
                break;
            case "BranchReturn":
                if (branchChoiceBox.getValue() != null) {
                    branch = branchChoiceBox.getValue().toString();
                    setPage(PageController4bca.class, "4bcb", new String[]{"return", branch});
                } else {
                    errorLabel.setVisible(true);
                }
                break;
        }
    }

    public void onClickBackButton() {
        setPage(PageController3bb.class, "2b");
    }
}
