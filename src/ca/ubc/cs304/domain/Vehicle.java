package ca.ubc.cs304.domain;

public class Vehicle {
    String vlicense;
    String make;
    String model;
    String year;
    String color;
    String odometer;
    String vtname;
    String location;
    String city;
    String status;

    public Vehicle(String vlicense, String make, String model, String year, String color, String odometer, String vtname, String location, String city, String status) {
        this.vlicense = vlicense;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.odometer = odometer;
        this.vtname = vtname;
        this.location = location;
        this.city = city;
        this.status = status;
    }

    public String getVlicense() {
        return vlicense;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getOdometer() {
        return odometer;
    }

    public String getVtname() {
        return vtname;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getStatus() {
        return status;
    }
}
