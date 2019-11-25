package ca.ubc.cs304.model;

public class ReturnReceipt {
    private String rentalId;
    private String confNo;
    private String date;
    private int vehicleRate;
    private int insuranceRate;
    private int totalPrice;

    public ReturnReceipt(String rentalId, String confNo, String date, int vehicleRate, int insuranceRate, int totalPrice) {
        this.rentalId = rentalId;
        this.confNo = confNo;
        this.date = date;
        this.vehicleRate = vehicleRate;
        this.insuranceRate = insuranceRate;
        this.totalPrice = totalPrice;
    }

    public String getRentalId() {
        return rentalId;
    }

    public String getConfNo() {
        return confNo;
    }

    public String getDate() {
        return date;
    }

    public int getVehicleRate() {
        return vehicleRate;
    }

    public int getInsuranceRate() {
        return insuranceRate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
