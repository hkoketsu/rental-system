package ca.ubc.cs304.domain;

import java.sql.Date;

public class TimePeriod {
    private Date fromDate;
    private Date toDate;
    private String fromTime;
    private String toTime;

    public TimePeriod(Date fromDate, Date toDate, String fromTime, String toTime) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getToTime() {
        return toTime;
    }
}
