package ca.ubc.cs304.controller;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class PageController2b extends PageController {
    public void onClick(ActionEvent e) {
        Button button = (Button) e.getSource();
        switch (button.getId()) {
            case "Rent W/ Reservation":
                setPage(PageController3ba.class, "3ba");
                break;
            case "Rent W/O Reservation":
                setPage(PageController2a.class, "2a", new Object[]{true});
                break;
            case "Return":
                setPage(PageController3bb.class, "3bb");
                break;
            case "Report":
                setPage(PageController3bc.class, "3bc");
                break;
        }

    }
}
