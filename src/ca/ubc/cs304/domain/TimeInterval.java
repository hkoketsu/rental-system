package ca.ubc.cs304.domain;

import java.sql.Date;

public class TimeInterval {
    private Date fromDate;
    private Date toDate;
    private String fromTime;
    private String toTime;

    public TimeInterval(Date fromDate, Date toDate, String fromTime, String toTime) {
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

    public String getFromDateFormatted() {
        return "to_date('" + fromDate.toString() + "', 'yyyy-mm-dd')";
    }

    public String getToDateFormatted() {
        return "to_date('" + toDate.toString() + "', 'yyyy-mm-dd')";
    }
}
