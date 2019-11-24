package ca.ubc.cs304.model;

import java.sql.Date;

public class ReturnReportBranch {
    // TODO: add more field variables if required
    private String city;
    private String vnum;
    private String vtype;
    private Double revenue;

    public ReturnReportBranch(String city,String vnum,  String vtype, Double revenue) {
        this.city = city;
        this.vnum = vnum;
        this.vtype = vtype;
        this.revenue = revenue;
    }

    public String getCity() {
        return city;
    }

    public String getVnum() {
        return vnum;
    }

    public String getVtype() {
        return vtype;
    }

    public Double getRevenue() {
        return revenue;
    }
}
