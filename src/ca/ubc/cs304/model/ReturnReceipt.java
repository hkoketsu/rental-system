package ca.ubc.cs304.model;

import java.sql.Date;

public class ReturnReceipt {
    // TODO: add more field variables if required
    private String confno;
    private Date returnDate;
    private Double cost;

    public ReturnReceipt(String confno, Date returnDate, Double cost) {
        this.confno = confno;
        this.returnDate = returnDate;
        this.cost = cost;
    }

    public String getConfno() {
        return confno;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Double getCost() {
        return cost;
    }
}
