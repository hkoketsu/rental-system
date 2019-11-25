package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Vehicle;
import ca.ubc.cs304.domain.reports.RentalReport;
import ca.ubc.cs304.domain.reports.ReturnReport;
import ca.ubc.cs304.domain.reports.ReturnReportBranchSummary;
import ca.ubc.cs304.service.ClerkHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/***
 * Page for company report
 */
public class PageController4bca extends PageController implements Initializable {
    private boolean forRent;


    @FXML TableView vehicleTable;
    @FXML Text totalTag;
    @FXML Text typeTag;
    @FXML Text VanTag;
    @FXML Text BurTag;
    @FXML Text SubTitleText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: send query to get data based on branch and category
        // ToDO: send query to get total number or revenue based on forRent



        TableColumn vlicenseCol = new TableColumn("License");
        vlicenseCol.setCellValueFactory(new PropertyValueFactory<>("vlicense"));

        TableColumn makeCol = new TableColumn("Make");
        makeCol.setCellValueFactory(new PropertyValueFactory<>("make"));

        TableColumn modelCol = new TableColumn("Model");
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn yearCol = new TableColumn("Year");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn colorCol = new TableColumn("Color");
        colorCol.setCellValueFactory(new PropertyValueFactory<>("vlicense"));

        TableColumn odometerCol = new TableColumn("Odometer");
        odometerCol.setCellValueFactory(new PropertyValueFactory<>("odometer"));

        TableColumn vtnameCol = new TableColumn("Type");
        odometerCol.setCellValueFactory(new PropertyValueFactory<>("vtname"));

        TableColumn locationCol = new TableColumn("Location");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn cityCol = new TableColumn("City");
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn statusCol = new TableColumn("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        vehicleTable.getColumns().addAll(vlicenseCol, makeCol, modelCol, yearCol, colorCol,
                odometerCol, vtnameCol, locationCol, cityCol, statusCol);





    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 1) {
            String[] paramsStr = (String[]) params[0];
            forRent = paramsStr[0].equals("rental");
            this.forRent = forRent;
            if(forRent)
                SubTitleText.setText("Daily Rental");
            else SubTitleText.setText("Daily Return");
        }
        DatabaseConnectionHandler dbHandler = new DatabaseConnectionHandler();

        ClerkHandler clerkHandler = new ClerkHandler(dbHandler);

        if(this.forRent) {
            RentalReport rentalReport = clerkHandler.generateRentalReport();

            ArrayList<Vehicle> vehicles = rentalReport.getVehicleList();

            vehicleTable.getItems().clear();

            for(Vehicle v: vehicles) {
                vehicleTable.getItems().add(v);
            }

            if(rentalReport.getTotal() != ""){
                String totalstr = rentalReport.getTotal();
                for(String s : rentalReport.getBranchSum()){
                    totalstr += "  ";
                    totalstr += s;
                }
                totalTag.setText(totalstr);
            }
            if(rentalReport.getTypeSum().size() > 0) {
                String typeResult = "";
                for(String s : rentalReport.getTypeSum()){
                    typeResult += s;
                    typeResult += "  ";
                }
                typeTag.setText(typeResult);
            }
        } else {
            ReturnReport returnReport = clerkHandler.generateReturnReport();
            ArrayList<Vehicle> vehicles = returnReport.getVehicleList();
            vehicleTable.getItems().clear();

            for(Vehicle v: vehicles) {
                vehicleTable.getItems().add(v);
            }

            if(returnReport.getTotal() != ""){
                String totalstr = returnReport.getTotal();
                for(String s : returnReport.getBranchSum()){
                    totalstr += "  ";
                    totalstr += s;
                }
                totalTag.setText(totalstr);
            }

            if(returnReport.getBranchSum().size() > 0) {
                String typeResult = "";
                for(String s : returnReport.getBranchSum()){
                    typeResult += s;
                    typeResult += "  ";
                }
                typeTag.setText(typeResult);
            }

            if(returnReport.getBreports().size()>1) {
                String VanSum = "Vancouver: ";
                String BurSum = "Burnaby: ";
                for(ReturnReportBranchSummary r: returnReport.getBreports()){
                    if(r.getCity() == "Vancouver")
                        VanSum += r.getSummary();
                }
                for(ReturnReportBranchSummary r: returnReport.getBreports()){
                    if(r.getCity() == "Burnaby")
                        BurSum += r.getSummary();
                }
                VanTag.setText("");
                BurTag.setText("");
                VanTag.setText(VanSum);
                BurTag.setText(BurSum);
            }

            dbHandler.close();

        }
    }

    public void onClickTopButton() {
        setPage(PageController1.class, "1");
    }
}
