package ca.ubc.cs304.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/***
 * Page for selecting a report type
 */
public class PageController3bc extends PageController implements Initializable {
    @FXML ChoiceBox branchChoiceBox;
    @FXML Label errorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // String[] branches = TODO: get all the branch by query
        // branchChoiceBox.setItems(branches);
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
