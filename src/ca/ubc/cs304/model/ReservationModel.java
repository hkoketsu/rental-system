package ca.ubc.cs304.model;

import java.sql.Date;
import java.sql.Time;

public class ReservationModel {
    private String confNo;
    private String vtname;
    private String cellphone;
    private Date fromDate;
    private String fromTime;
    private Date toDate;
    private String toTime;

    public ReservationModel(String confNo, String vtname, String cellphone, Date fromDate, String fromTime, Date toDate, String toTime) {
        this.confNo = confNo;
        this.vtname = vtname;
        this.cellphone = cellphone;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.toDate = toDate;
        this.toTime = toTime;
    }

    public String getConfNo() {
        return confNo;
    }

    public String getVtname() {
        return vtname;
    }

    public String getCellphone() {
        return cellphone;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public Date getToDate() {
        return toDate;
    }

    public String getToTime() {
        return toTime;
    }
}
