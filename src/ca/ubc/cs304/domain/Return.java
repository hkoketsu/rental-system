package ca.ubc.cs304.domain;

import java.sql.Date;

public class Return {
    private String id;
    private Date date;
    private String time;
    private int odometer;
    private boolean fullTank;
    private int value;

    public Return(String id, Date date, String time, int odometer, boolean fullTank, int value) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.odometer = odometer;
        this.fullTank = fullTank;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getOdometer() {
        return odometer;
    }

    public boolean isFullTank() {
        return fullTank;
    }

    public int getValue() {
        return value;
    }
}
