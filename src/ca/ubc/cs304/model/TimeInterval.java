package ca.ubc.cs304.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class TimeInterval {
    Date fromDate;
    Date toDate;
    String fromTime;
    String toTime;

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
}
