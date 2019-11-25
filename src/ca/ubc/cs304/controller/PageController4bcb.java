package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Vehicle;
import ca.ubc.cs304.domain.reports.RentalBranchReport;
import ca.ubc.cs304.domain.reports.RentalReport;
import ca.ubc.cs304.domain.reports.ReturnBranchReport;
import ca.ubc.cs304.domain.reports.ReturnReportBranchSummary;
import ca.ubc.cs304.service.ClerkHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/***
 * Page for branch report
 */
public class PageController4bcb extends PageController implements Initializable {
    private boolean forRent;
    private String branch;

    @FXML Text branchTag;
    @FXML Text totalTag;
    @FXML Text typeTag;
    @FXML Text VanTag;
    @FXML Text BurTag;
    @FXML TableView vehicleTable;
    @FXML Text SubTitleText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: send query to get data based on category
        // ToDO: send query to get total number or revenue based on forRent

        DatabaseConnectionHandler dbHandler = new DatabaseConnectionHandler();

        ClerkHandler clerkHandler = new ClerkHandler(dbHandler);
        String blocation = "";
        if(this.branch == "Vancouver")
            blocation = "122 Walter Hardwick Ave 305";
        else blocation = "5202 Union St";


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

        if(forRent) {
            RentalBranchReport rentalBranchReport = clerkHandler.generateBranchRentalReport(blocation, this.branch);

            ArrayList<Vehicle> vehicles = rentalBranchReport.getVehicleList();

            for(Vehicle v: vehicles) {
                vehicleTable.getItems().add(v);
            }

            if(rentalBranchReport.getTotal() != ""){
                String totalstr = rentalBranchReport.getTotal();
                totalTag.setText(totalstr);
            }
            if(rentalBranchReport.getTypeSum().size() > 0) {
                String typeResult = "";
                for(String s : rentalBranchReport.getTypeSum()){
                    typeResult += s;
                    typeResult += "  ";
                }
                typeTag.setText(typeResult);
            }
        }else {
            ReturnBranchReport returnBranchReport = clerkHandler.generateBranchReturnReport(blocation, this.branch);

            ArrayList<Vehicle> vehicles = returnBranchReport.getVehicleList();

            for(Vehicle v: vehicles) {
                vehicleTable.getItems().add(v);
            }

            if(returnBranchReport.getTotal() != ""){
                String totalstr = returnBranchReport.getTotal();
                totalTag.setText(totalstr);
            }
            if(returnBranchReport.getBreports().size()>1) {
                String VanSum = "Vancouver: ";
                String BurSum = "Burnaby: ";
                for(ReturnReportBranchSummary r: returnBranchReport.getBreports()){
                    if(r.getCity() == "Vancouver")
                        VanSum += r.getSummary();
                }
                for(ReturnReportBranchSummary r: returnBranchReport.getBreports()){
                    if(r.getCity() == "Burnaby")
                        BurSum += r.getSummary();
                }

                VanTag.setText("");
                BurTag.setText("");

                if(this.branch == "Vancouver")
                    VanTag.setText(VanSum);
                else BurTag.setText(BurSum);
            }

        }




    }

    @Override
    public void loadParameter(Object[]...params) {
        if (params != null && params[0].length == 2) {
            String[] paramsStr = (String[]) params[0];
            forRent = paramsStr[0].equals("rental");
            branch = paramsStr[1];
            this.branch = branch;
            this.forRent = forRent;
            branchTag.setText("Branch: "+ branch);
            if(forRent)
                SubTitleText.setText("Daily Rental");
            else SubTitleText.setText("Daily Return");
        }
    }

    public void onClickTopButton() {
        setPage(PageController1.class, "1");
    }
}
