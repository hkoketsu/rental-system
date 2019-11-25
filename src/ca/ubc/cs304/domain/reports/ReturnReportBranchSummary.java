package ca.ubc.cs304.domain.reports;

public class ReturnReportBranchSummary {
    private String city;
    private String vnum;
    private String vtype;
    private Double revenue;


    public ReturnReportBranchSummary(String city, String vehicles, String vtype, Double revenue) {
        this.city = city;
        this.vnum = vehicles;
        this.vtype = vtype;
        this.revenue = revenue;
    }
    //This is the city name
    public String getCity() {return city;}
    //This is the number of vehicles returned that is of Vtype for specific branch
    public String getVnum() {return vnum;}
    //This is the vehicle type
    public String getVtype() {return vtype;}
    //This is the total revenue of Vtype for specific branch
    public Double getRevenue() {return revenue;}

    public String getSummary() {
        return "#"+getVtype()+": "+ getVnum() +" revenue: "+ getRevenue();
    }

}
