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

public class PageController1_1b extends PageController implements Initializable {
    @FXML ChoiceBox cityChoiceBox;

    private DatabaseConnectionHandler dbHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbHandler = new DatabaseConnectionHandler();

        List<String> cities = dbHandler.getCityInfo();

        ObservableList<String> cityItems = FXCollections.observableArrayList(cities);
        cityChoiceBox.setItems(cityItems);
    }

    public void onClickNextButton() {
        String city = cityChoiceBox.getValue().toString();
        setPage(PageController1_2b.class, "1_2b", new String[]{city});
    }

    public void onClickBackButton() {
        setPage(PageController1.class, "1");
    }
}
