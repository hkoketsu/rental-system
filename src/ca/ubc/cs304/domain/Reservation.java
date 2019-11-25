package ca.ubc.cs304.domain;

import java.sql.Date;

public class Reservation {
    private String id;
    private String vehicleType;
    private String customerId;
    private String branchId;
    private TimeInterval duration;

    public Reservation(String id, String vehicleType, String customerId, String branchId, TimeInterval duration) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.customerId = customerId;
        this.branchId = branchId;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getBranchId() { return branchId; }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public TimeInterval getDuration() {
        return duration;
    }
}