package ca.ubc.cs304.repository;

import java.sql.Connection;

public class BranchRepository {
    private Connection connection;

    public BranchRepository(Connection connection) {
        this.connection = connection;
    }

}
