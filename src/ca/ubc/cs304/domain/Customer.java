package ca.ubc.cs304.domain;

public class Customer {
    String dlicense;
    String cellphone;
    String name;
    String address;

    public Customer(String dlicense, String cellphone, String name, String address) {
        this.dlicense = dlicense;
        this.cellphone = cellphone;
        this.name = name;
        this.address = address;
    }

    public String getDlicense() {
        return dlicense;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
