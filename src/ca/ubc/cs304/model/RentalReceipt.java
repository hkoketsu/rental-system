package ca.ubc.cs304.model;

import java.sql.Date;

public class RentalReceipt {
    private String confno;
    private Date fromDate;
    private Date toDate;
    private String carType;
    private String location;

    public RentalReceipt(String confno, Date fromDate, Date toDate, String carType, String location) {
        this.confno = confno;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.carType = carType;
        this.location = location;
    }

    public String getConfno() {
        return confno;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public String getCarType() {
        return carType;
    }

    public String getLocation() {
        return location;
    }
}
