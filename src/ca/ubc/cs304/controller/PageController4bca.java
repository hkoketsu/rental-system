package ca.ubc.cs304.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/***
 * Page for company report
 */
public class PageController4bca extends PageController implements Initializable {
    private boolean forRent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: send query to get data based on branch and category
        // ToDO: send query to get total number or revenue based on forRent
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 1) {
            String[] paramsStr = (String[]) params[0];
            forRent = paramsStr[0].equals("rental");
        }
    }

    public void onClickTopButton() {
        setPage(PageController1.class, "1");
    }
}
