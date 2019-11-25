package ca.ubc.cs304.domain.receipt;

import java.sql.Date;

public class ReturnReceipt {
    private String rentalId;
    private String confNo;
    private Date date;
    private int vehicleRate;
    private int insuranceRate;
    private int distanceRate;
    private int totalPrice;

    public ReturnReceipt(String rentalId, String confNo, Date date, int vehicleRate, int insuranceRate, int distanceRate, int totalPrice) {
        this.rentalId = rentalId;
        this.confNo = confNo;
        this.date = date;
        this.vehicleRate = vehicleRate;
        this.insuranceRate = insuranceRate;
        this.distanceRate = distanceRate;
        this.totalPrice = totalPrice;
    }

    public String getRentalId() {
        return rentalId;
    }

    public String getConfNo() {
        return confNo;
    }

    public Date getDate() {
        return date;
    }

    public int getVehicleRate() {
        return vehicleRate;
    }

    public int getInsuranceRate() {
        return insuranceRate;
    }

    public int getDistanceRate() { return distanceRate; }

    public int getTotalPrice() {
        return totalPrice;
    }
}
