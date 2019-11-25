package ca.ubc.cs304.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/***
 * Page for selecting clerk actions
 */
public class PageController2b extends PageController {
    private String branchLocation;

    public void onClick(ActionEvent e) {
        Button button = (Button) e.getSource();
        switch (button.getId()) {
            case "Rent W/ Reservation":
                setPage(PageController3ba.class, "3ba", new String[]{branchLocation});
                break;
            case "Rent W/O Reservation":
                setPage(PageController2a.class, "2a", new Object[]{branchLocation, true});
                break;
            case "Return":
                setPage(PageController3bb.class, "3bb");
                break;
            case "Report":
                setPage(PageController3bc.class, "3bc");
                break;
        }
    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 1) {
            branchLocation = params[0][0].toString();
        }
    }
}
