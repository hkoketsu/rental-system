package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class PageController1_2b extends PageController implements Initializable {
    @FXML ChoiceBox branchChoiceBox;

    private DatabaseConnectionHandler dbHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbHandler = new DatabaseConnectionHandler();
    }

    public void onClickNextButton() {
        String branchLocation = branchChoiceBox.getValue().toString();
        setPage(PageController2b.class, "2b", new String[]{branchLocation});
    }

    public void onClickBackButton() {
        setPage(PageController1.class, "1_1b");
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 1) {
            String city = params[0][0].toString();
            List<String> branchLocations = dbHandler.getBranchLocations(city);
            ObservableList<String> branchLocationItems = FXCollections.observableArrayList(branchLocations);
            branchChoiceBox.setItems(branchLocationItems);
        }
    }

}