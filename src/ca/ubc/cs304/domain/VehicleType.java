package ca.ubc.cs304.domain;

public class VehicleType {
    private String id;
    private String features;
    private VehicleRate vehicleRate;
    private InsuranceRate insuranceRate;
    private int kmRate;

    public VehicleType(String id, String features, VehicleRate vehicleRate, InsuranceRate insuranceRate, int kmRate) {
        this.id = id;
        this.features = features;
        this.vehicleRate = vehicleRate;
        this.insuranceRate = insuranceRate;
        this.kmRate = kmRate;
    }

    public String getId() {
        return id;
    }

    public String getFeatures() {
        return features;
    }

    public VehicleRate getVehicleRate() {
        return vehicleRate;
    }

    public InsuranceRate getInsuranceRate() {
        return insuranceRate;
    }

    public int getKmRate() {
        return kmRate;
    }
}
