package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;

public class CustomerHandler {

    private DatabaseConnectionHandler cdh;

    public CustomerHandler (DatabaseConnectionHandler cdh) {
        this.cdh = cdh;
    }
}
