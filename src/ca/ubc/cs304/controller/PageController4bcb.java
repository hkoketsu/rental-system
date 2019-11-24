package ca.ubc.cs304.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/***
 * Page for branch report
 */
public class PageController4bcb extends PageController implements Initializable {
    private boolean forRent;
    private String branch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: send query to get data based on category
        // ToDO: send query to get total number or revenue based on forRent
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 2) {
            String[] paramsStr = (String[]) params[0];
            forRent = paramsStr[0].equals("rental");
            branch = paramsStr[1];
        }
    }

    public void onClickTopButton() {
        setPage(PageController1.class, "1");
    }
}
