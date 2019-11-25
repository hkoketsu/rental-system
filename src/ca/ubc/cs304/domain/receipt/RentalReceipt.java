package ca.ubc.cs304.domain.receipt;

import java.sql.Date;

public class RentalReceipt {
    private String rentalId;
    private String confNo;
    private String customerName;
    private String pickupDateTime;
    private String returnDateTime;
    private String vehicleType;
    private String location;

    public RentalReceipt(String rentalId, String confNo, String customerName, String pickupDateTime, String returnDateTime, String vehicleType, String location) {
        this.rentalId = rentalId;
        this.confNo = confNo;
        this.customerName = customerName;
        this.pickupDateTime = pickupDateTime;
        this.returnDateTime = returnDateTime;
        this.vehicleType = vehicleType;
        this.location = location;
    }

    public String getRentalId() {
        return rentalId;
    }

    public String getConfNo() {
        return confNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPickupDateTime() {
        return pickupDateTime;
    }

    public String getReturnDateTime() {
        return returnDateTime;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getLocation() {
        return location;
    }
}
