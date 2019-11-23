package ca.ubc.cs304.controller;

import ca.ubc.cs304.domain.Util;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/***
 * Page for displaying reservation completion
 */
public class PageController5a extends PageController implements Initializable {
    private String confirmationNumber;

    private String vehicleType;
    private String licenseNumber;
    private Date pickupDate;
    private String pickupTime;
    private Date returnDate;
    private String returnTime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        confirmationNumber = Util.generateConfirmationNumber();
        // TODO: check whether it is already in rental table,
        //  and if so, get another number, else use the number to send the query
    }

    @Override
    public void loadParameter(Object[]...params) {
        String[] paramsStr = (String[]) params[0];
        vehicleType = paramsStr[0];
        licenseNumber = paramsStr[1];
        String pickupDateTime = paramsStr[2];
        String returnDateTime = paramsStr[3];

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            pickupDate = new Date(df.parse(pickupDateTime.split(" ")[0]).getTime());
            returnDate = new Date(df.parse(returnDateTime.split(" ")[0]).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pickupTime = pickupDateTime.split(" ")[1];
        returnTime = returnDateTime.split(" ")[1];
    }

    public void onClickTopButton() {
        setPage(PageController2a.class, "2a");
    }
}
