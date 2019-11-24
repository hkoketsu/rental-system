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

    public String getFromDateFormated() {
        return "to_date('" + fromDate.toString() + "', 'yyyy-mm-dd')";
    }

    public Date getToDate() {
        return toDate;
    }

    public String getToDateFormated() {
        return "to_date('" + toDate.toString() + "', 'yyyy-mm-dd')";
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getToTime() {
        return toTime;
    }
}
