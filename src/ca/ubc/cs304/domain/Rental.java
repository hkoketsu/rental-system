package ca.ubc.cs304.domain;

public final class Rental {
    private String id;
    private String vehicleId;
    private String customerId;
    private TimeInterval duration;
    private int odometer;
    private CreditCard creditCard;
    private String confirmationNumber;

    public Rental(String id, String vehicleId, String customerId, TimeInterval duration, int odometer, CreditCard creditCard, String confirmationNumber) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.duration = duration;
        this.odometer = odometer;
        this.creditCard = creditCard;
        this.confirmationNumber = confirmationNumber;
    }

    public String getId() {
        return id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public TimeInterval getDuration() {
        return duration;
    }

    public int getOdometer() {
        return odometer;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }
}
